package com.eureka.customer1.service;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getError"//commandKey = "userServiceGetResultKey"
//        commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
//        }
    )
    public String getResult() {

        String result = "";
        long startTime = System.currentTimeMillis();

        long endTime = 0;
        Date date = new Date();
        String dateStr = "20210914 " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();

        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(
                "http://provider/user/message?dateStr=" + dateStr, JSONObject.class);
        result = (String) responseEntity.getBody().get("result");
        endTime = System.currentTimeMillis();


        log.info("dateStr: {}, spent time: {}, result: {}", dateStr, endTime - startTime, result);
        return result;
    }

    public String getError() {
        return "报错了！";
    }
}
