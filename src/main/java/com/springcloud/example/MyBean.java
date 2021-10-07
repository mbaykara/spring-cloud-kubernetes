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
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "spring")
public class MyBean {

	private String name;

	private String version;

	@Scheduled(fixedDelay = 2000)
	public void hello() {
		System.out.println("The first message is: " + this.name);
		System.out.println("The second message is: " + this.version);
	}

}