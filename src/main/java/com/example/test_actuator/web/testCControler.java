package com.example.test_actuator.web;

import com.example.test_actuator.config.WebSocketLogAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testCControler {

    private static final Logger logger = LoggerFactory.getLogger(testCControler.class);


    @GetMapping()
    public String test()
    {
        logger.info("test log");
        logger.warn("test log");
        logger.error("test log");
        return "hello word";
    }
}
