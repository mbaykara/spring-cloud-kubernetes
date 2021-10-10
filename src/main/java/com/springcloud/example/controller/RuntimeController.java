package com.springcloud.example.controller;

import com.springcloud.example.MyBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuntimeController {

    private static Logger log = LoggerFactory.getLogger(RuntimeController.class);

    private MyBean mybean;

    public RuntimeController(MyBean mybean) {
        this.mybean = mybean;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/version")
    public String getPropertyValue(){
        log.info("spring.version:" + mybean.getVersion());
        return mybean.getVersion();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/name")
    public String getPropertyName(){
        log.info("name:" + mybean.getName());
        return mybean.getName();
    }
}