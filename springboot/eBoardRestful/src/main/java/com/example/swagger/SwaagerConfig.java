package com.example.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration //spring
@RequiredArgsConstructor //lombok
//@OpenAPIDefinition(info=@info(title="swagger_title",version="version"))
public class SwaagerConfig {
	
	@Bean
	public GroupedOpenApi chatOpenApi() {
		String [] paths = { "/board/**" };
		return GroupedOpenApi.builder().group("API v1").pathsToMatch(paths).build();
	}
}
