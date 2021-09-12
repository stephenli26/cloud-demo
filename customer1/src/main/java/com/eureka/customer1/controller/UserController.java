package com.eureka.customer1.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "result")
    public String getResult() {
        int provider1Count = 0;
        int provider2Count = 0;

        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(
                "http://provider/user/message", JSONObject.class);
        String result = (String) responseEntity.getBody().get("result");
        if ("1".equals(result)) {
            provider1Count++;
        } else if ("2".equals(result)) {
            provider2Count++;
        }
        log.info("result: {}", result);

        log.info("provider1Count: {}", provider1Count);
        log.info("provider1Count: {}", provider2Count);

        return "provider1Count: " + provider1Count + ", provider1Count: " + provider2Count;

    }
}
