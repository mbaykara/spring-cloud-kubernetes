package com.springcloud.springcloudkubernetes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableScheduling
public class RuntimeController {

    private static Logger log = LoggerFactory.getLogger(RuntimeController.class);

    private MyBean mybean;

    public RuntimeController(MyBean mybean) {
        this.mybean = mybean;
    }

    @Scheduled(fixedDelay = 5000)
    public void hello() {
         log.info("spring.version: " + mybean.getVersion());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/version")
    public String getPropertyValue(){
        log.info("spring.version:" + mybean.getVersion());
        return mybean.getVersion();
    }
}