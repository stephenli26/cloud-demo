package com.eureka.customer2;

import org.springframework.stereotype.Component;

@Component
public class DefaultFallback implements UserService{

    @Override
    public String getMessage(String dateStr) {
        return "报错了！";
    }
}
