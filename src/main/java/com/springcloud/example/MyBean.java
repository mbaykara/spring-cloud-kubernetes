package com.springcloud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Component
// @ConfigurationProperties()
@PropertySource("test.yml")
public class MyBean {

	@Value("${name}")
	private String name;

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		System.out.println("The first message is: " + this.name);
	}

}