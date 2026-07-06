package com.cognizant.springboot_hello_world.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")

    public String sayHello(){
        logger.info("Calling the sayHello function for /hello path");
        logger.info("Returning the result from sayHello function for /hello path");
        return "<h2>Hello World!!</h2>";
    }
}
