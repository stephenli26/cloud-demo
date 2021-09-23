package com.eureka.customer2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider", fallback = DefaultFallback.class)
public interface UserService {
    @GetMapping("/user/message/{dateStr}")
    public String getMessage(@PathVariable("dateStr") String dateStr);
}
