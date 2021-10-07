package com.springcloud.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties()
@Data
public class MyBean {

	@Value("${spring.application.name:default-value}")
	private String name;

	@Scheduled(fixedDelay = 2000)
	public void hello() {
		System.out.println("The first message is: " + this.name);
	}

}