package com.healthdomian.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "app")
@Configuration
public class AppProperties {
	
	Map<String , String>  messages=new HashMap<>();
	

}
