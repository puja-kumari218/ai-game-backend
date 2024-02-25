package com.example.aigame;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloControlller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
}
