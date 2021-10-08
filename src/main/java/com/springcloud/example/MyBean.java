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
import org.springframework.cloud.context.config.annotation.RefreshScope;
// @Component
// @ConfigurationProperties()

@Data
@Configuration
@RefreshScope
public class MyBean {

	@Value("${name: default}")
	private String name;

	@Value("${spring.version: default}")
	private String version;

}