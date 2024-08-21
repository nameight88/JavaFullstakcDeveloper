package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	public void addCorsMappings(CorsRegistry regisry) {
		regisry.addMapping("/**")
		.allowedOrigins("http://localhost:3000")
		.allowedMethods("GET","POST","PUT","DELETE");
	}
}
 