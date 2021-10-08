package com.springcloud.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@Configuration
@RefreshScope
public class MyBean {

	@Value("${name: default}")
	private String name;

	@Value("${spring.version: default}")
	private String version;

}