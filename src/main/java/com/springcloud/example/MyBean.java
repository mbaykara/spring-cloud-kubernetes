package com.springcloud.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

@ConfigurationProperties(prefix = "spring")
public class MyBean {
  
  @Value("${spring.application.name:default-value}")
	private String name;

	private String version;

	@Scheduled(fixedDelay = 2000)
	public void hello() {
		System.out.println("The first message is: " + this.name);
		System.out.println("The second message is: " + this.version);
	}

}