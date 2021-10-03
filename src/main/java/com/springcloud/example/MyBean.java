package com.springcloud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Autowired
	private PropertiesConfig myConfig;

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		System.out.println("The first message is: " + this.myConfig.getSurname());
        System.out.println("The second message is: " + this.myConfig.getName());
	}

}