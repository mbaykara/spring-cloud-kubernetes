package com.springcloud.springcloudkubernetes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class MyBean {

	@Value("${spring.application.name: default}")
	private String name;

	@Value("${spring.version: default}")
	private String version;

    public String getVersion(){
        return this.version;
    }

    public void setVersion(String version){
         this.version=  version;
    }

}