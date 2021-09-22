package com.eureka.provider2.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {

    @RequestMapping(value = "message/{dateStr}")
    public Map<String, String> message(@PathVariable("dateStr")  String dateStr) {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "2");
        log.info("provider2, dateStr: {}, result: {}", dateStr, result);

        return result;
    }

    @RequestMapping(value = "notice")
    public Map<String, String> notice(@RequestParam("dateStr")String dateStr) {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "This is provider2 notice");
        return result;
    }
}

