package com.eureka.provider2.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {

    @RequestMapping(value = "message")
    public Map<String, String> message(String dateStr) {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "1");
        log.info("provider2, dateStr: {}, result: {}", dateStr, result);

        return result;
    }

    @RequestMapping(value = "notice")
    public Map<String, String> notice(String code) {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "This is provider2 notice");
        return result;
    }
}

