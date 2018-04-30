package com.automateditsolutions.springbootdemo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webHWController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value="name")String name){
        return "Hellow " + name +"!";
    }

    @RequestMapping("/")
    String home() {
        return "home";
    }
}
