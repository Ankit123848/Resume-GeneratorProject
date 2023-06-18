package com.resumegenerator;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ResumegeneratorprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResumegeneratorprojectApplication.class, args);
		
	}
	
	
	@Bean    
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() { 
			@Override            
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/save").allowedOrigins("http://localhost:4200"); 
				registry.addMapping("/signup").allowedOrigins("http://localhost:4200");
                registry.addMapping("/login").allowedOrigins("http://localhost:4200");
				} 
			};
	}
	

}
