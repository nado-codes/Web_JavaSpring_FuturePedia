package com.futurepedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FuturepediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturepediaApplication.class, args);
	}

	/*
	 * @Bean
	 * public WebMvcConfigurer corsConfigurer() {
	 * return new WebMvcConfigurer() {
	 * 
	 * @Override
	 * public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/articles/*").allowedOrigins("http://localhost:3000");
	 * registry.addMapping("/articles/*").allowedMethods("GET");
	 * }
	 * };
	 * }
	 */

}
