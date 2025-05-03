package com.example.post_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {
	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			System.out.println("===> "+ auth);
			
			if (auth != null && auth.getCredentials() != null) {
				String token = auth.getCredentials().toString();
				
				System.out.println("===> "+ token);
				
				requestTemplate.header("Authorization", "Bearer " + token);
			}
		};
	}
}
