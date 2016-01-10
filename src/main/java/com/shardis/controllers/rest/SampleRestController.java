package com.shardis.controllers.rest;


import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
