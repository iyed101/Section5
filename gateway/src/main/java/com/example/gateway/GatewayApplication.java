package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Configuration
	public class CorsConfig {
		@Bean
		public WebFilter corsFilter() {
			return (ServerWebExchange ctx, WebFilterChain chain) -> {
				ctx.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
				ctx.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
				ctx.getResponse().getHeaders().add("Access-Control-Allow-Headers",
						"Origin, Content-Type, Accept, Authorization");
				ctx.getResponse().getHeaders().add("Access-Control-Allow-Credentials", "true");
				return chain.filter(ctx);
			};
		}
	}
}
