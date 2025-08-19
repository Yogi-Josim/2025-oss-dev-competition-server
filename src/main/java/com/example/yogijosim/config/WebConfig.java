package com.example.yogijosim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // 모든 경로에 대해 CORS 정책 적용
			.allowedOrigins(
				"http://localhost:3000",
				"https://yogijosim.netlify.app"
			)
			.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // OPTIONS 메서드 허용 필수
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(3600);
	}
}