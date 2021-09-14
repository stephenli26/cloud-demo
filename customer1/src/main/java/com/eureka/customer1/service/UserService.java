package com.eureka.customer1.service;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@DefaultProperties(defaultFallback = "getError")
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(commandKey = "userServiceGetResultKey")
    //(fallbackMethod = "getError"//commandKey = "userServiceGetResultKey"
//        commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
//        }
    //)
    public String getMessage() {
        Date date = new Date();
        String url = "http://provider/user/message?dateStr={dateStr}";
        return callMethod(url);
    }

    @HystrixCommand(commandKey = "userServiceGetResultKey")
    public String getNotice() {
        Date date = new Date();
        String url = "http://provider/user/notice?dateStr={dateStr}";
        return callMethod(url);
    }

    public String callMethod(String url) {
        long startTime = System.currentTimeMillis();
        Map<String, Object> paramMap = new HashMap<>();
        String dateStr = getDate();
        paramMap.put("dateStr", dateStr);
        ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url,
                JSONObject.class,
                paramMap);
        String result = (String) responseEntity.getBody().get("result");
        long endTime = System.currentTimeMillis();
        log.info("url: {}, param: {}, spent time: {}, result: {}", url, paramMap, endTime - startTime, result);
        return result;
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
    }

    public String getError() {
        return "报错了！";
    }
}
