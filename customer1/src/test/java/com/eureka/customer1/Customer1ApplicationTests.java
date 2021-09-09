package com.eureka.customer1;

import com.alibaba.fastjson.JSONObject;
import com.eureka.customer1.config.MySelfRule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@Slf4j
class Customer1ApplicationTests {


    @Autowired
    MySelfRule mySelfRule;

    @Test
    void contextLoads() {
        /*
            RestTemplate可以发送HTTP GET请求，经常使用到的方法有两个：
            getForObject()
            getForEntity()
            二者的主要区别在于，getForObject()返回值是HTTP协议的响应体。getForEntity()返回的是ResponseEntity，ResponseEntity是对HTTP响应的封装，除了包含响应体，还包含HTTP状态码、contentType、contentLength、Header等信息。
         */

        int provider1Count = 0;
        int provider2Count = 0;

        for (int i=0; i< 200;i++) {
            ResponseEntity<JSONObject> responseEntity = mySelfRule.getRestTemplate().getForEntity("http://provider/user/message",JSONObject.class);
            String result = (String) responseEntity.getBody().get("result");
            if ("1".equals(result)) {
                provider1Count++;
            } else if ("2".equals(result)) {
                provider2Count++;
            }
            log.info("result: {}", result);
            log.info("provider1Count: {}", provider1Count);
            log.info("provider2Count: {}", provider2Count);
        }



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
