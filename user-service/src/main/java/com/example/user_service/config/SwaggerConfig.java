package com.example.user_service.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${swagger.server-url}")
	private String gatewayUrl;

	@Bean
	public OpenAPI customOpenAPI() {

		Server server = new Server()
				.url(gatewayUrl)
                .description("Gateway URL");;

		return new OpenAPI().info(
				new Info()
				.title("User service API")
				.version("1.0"))
				.servers(List.of(server))
				.components(
						new Components()
						.addSecuritySchemes("bearerAuth",
						new SecurityScheme()
						.type(SecurityScheme.Type.HTTP)
						.scheme("bearer")
						.bearerFormat("JWT")))
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}
}
