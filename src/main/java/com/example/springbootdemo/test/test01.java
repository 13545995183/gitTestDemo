package com.example.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class test01 {
    @GetMapping("hi")
    public String hi(){
        String messageId = String.valueOf(UUID.randomUUID());
        return "hi:"+messageId;
    }
}
