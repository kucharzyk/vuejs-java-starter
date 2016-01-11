package com.shardis.controllers.rest;


import com.google.common.collect.Lists;
import com.shardis.dto.user.UserPost;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Tomasz Kucharzyk
 */

@RestController
@RequestMapping("/rest")
public class SampleRestController {

    @RequestMapping("/test")
    public List<String> test() {
        return Lists.newArrayList("Vue.js", "is", "great");
    }

    @RequestMapping("/fail")
    public List<String> fail() {
        throw new RuntimeException("method failed");
    }

    @RequestMapping("/user/{userId}/posts")
    public List<UserPost> userPosts(@PathVariable("userId") Long userId) {
        List<UserPost> posts = Lists.newArrayList();
        for (long i = 1; i <= 8; i++) {
            posts.add(new UserPost(i, "Post #" + i + " of user " + userId, "sample content #" + i, LocalDateTime.now()));
        }
        return posts;
    }

    @RequestMapping("/user/{userId}/settings")
    public List<String> userSettings(@PathVariable("userId") Long userId) throws InterruptedException {
        //Don't do that at home
        Thread.currentThread().sleep(1000);

        List<String> settings = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            settings.add("Setting #" + i+" of user "+userId);
        }
        return settings;
    }
}
