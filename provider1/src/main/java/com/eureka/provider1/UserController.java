package com.eureka.provider1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "message/{dateStr}")
    public Map<String, String> message(@PathVariable("dateStr")  String dateStr) {
        Map<String, String> result  = new HashMap<>();
        long startTime = System.currentTimeMillis();
        try {

            Thread.sleep(new Random().nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        result.put("result", "1");
        log.info("provider1 message, dateStr: {}, result: {}, spent time: {}", dateStr, result, endTime - startTime);

        return result;
    }

    @RequestMapping(value = "notice")
    public Map<String, String> notice(@RequestParam(value = "dateStr", required = false) String dateStr) {
        Map<String, String> result  = new HashMap<>();
        long startTime = System.currentTimeMillis();
        try {

            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        result.put("result", "1");
//        log.info("provider1 notice , dateStr: {}, result: {}, spent time: {}", dateStr, result, endTime - startTime);
        return result;
    }
}
