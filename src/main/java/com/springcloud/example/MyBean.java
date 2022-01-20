package com.springcloud.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties
@RefreshScope
@Configuration
public class MyBean {

	@Value("${spring.application.name: default}")
	private String name;

	@Value("${spring.version: default}")
	private String version;

}