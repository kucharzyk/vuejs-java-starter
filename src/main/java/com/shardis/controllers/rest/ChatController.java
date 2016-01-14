package com.shardis.controllers.rest;


import com.shardis.dto.chat.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tomasz Kucharzyk
 */

@Slf4j
@RestController
@RequestMapping("/rest/chat")
public class ChatController {

    private final List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    @RequestMapping(path = "/post", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    ChatMessage jsonCreate(@RequestBody ChatMessage chatMessage) throws IOException {
        synchronized (this.sseEmitters) {
            for (SseEmitter sseEmitter : this.sseEmitters) {
                // Servlet containers don't always detect ghost connection, so we must catch exceptions ...
                try {
                    sseEmitter.send(chatMessage, MediaType.APPLICATION_JSON);
                } catch (Exception e) {
                }
            }
        }
        return chatMessage;
    }

    @RequestMapping("/sse/updates")
    SseEmitter subscribeUpdates() {
        SseEmitter sseEmitter = new SseEmitter();
        synchronized (this.sseEmitters) {
            this.sseEmitters.add(sseEmitter);
            sseEmitter.onCompletion(() -> {
                synchronized (this.sseEmitters) {
                    this.sseEmitters.remove(sseEmitter);
                }
            });
        }
        return sseEmitter;
    }
}
