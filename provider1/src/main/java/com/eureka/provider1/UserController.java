package com.eureka.provider1;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "message")
    public Map<String, String> message() {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "1");
        return result;
    }

    @RequestMapping(value = "notice")
    public Map<String, String> notice(String code) {
        Map<String, String> result  = new HashMap<>();
        result.put("result", "This is provider1 notice");
        return result;
    }
}
