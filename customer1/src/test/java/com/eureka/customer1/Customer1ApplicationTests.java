package com.eureka.customer1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Customer1ApplicationTests {

    @Test
    void contextLoads() {




//        JSONObject response = restTemplate.getForObject("http://provider/user/message",JSONObject.class);
//        log.info("{}", response.get("result"));
//
//        Map<String, String> paramMap = new HashMap<>();
//        paramMap.put("code", "1");
//
//        ResponseEntity<JSONObject> responseEntityPost = restTemplate.postForEntity("http://provider/user/message", paramMap, JSONObject.class);
//        log.info("{}", responseEntityPost.getBody().get("result"));
//
//        JSONObject responsePost = restTemplate.postForObject("http://provider/user/message",paramMap, JSONObject.class);
//        log.info("{}", responsePost.get("result"));

    }

}
