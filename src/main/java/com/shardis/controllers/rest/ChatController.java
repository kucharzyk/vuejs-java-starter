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
import java.util.concurrent.TimeUnit;

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
        log.info("Message received -> resending to " + sseEmitters.size() + " client(s)");
        synchronized (sseEmitters) {
            for (SseEmitter sseEmitter : sseEmitters) {
                sseEmitter.send(chatMessage, MediaType.APPLICATION_JSON);
            }
        }
        return chatMessage;
    }

    @RequestMapping("/sse/updates")
    SseEmitter subscribeUpdates() {
        SseEmitter sseEmitter = new SseEmitter(TimeUnit.MINUTES.toMillis(1));
        synchronized (sseEmitters) {
            this.sseEmitters.add(sseEmitter);
            log.info("Client connected");
            sseEmitter.onCompletion(() -> {
                synchronized (sseEmitters) {
                    sseEmitters.remove(sseEmitter);
                    log.info("Client disconnected");
                }
            });
        }
        return sseEmitter;
    }
}
