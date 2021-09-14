package com.eureka.customer1.controller;

import com.alibaba.fastjson.JSONObject;
import com.eureka.customer1.service.UserService;
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
    UserService service;

    @GetMapping(value = "result")
    public String getResult() {
        return service.getResult();
    }
}
