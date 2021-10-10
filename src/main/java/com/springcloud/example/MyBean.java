package com.springcloud.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class MyBean {

	@Value("${spring.application.name:default}")
	private String name;

	@Value("${project.version:default}")
	private String version;

}