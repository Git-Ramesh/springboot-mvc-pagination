package com.rs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.rs.app.repository")
@EntityScan(basePackages = "com.rs.app.model")
public class SpringbootPaginationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPaginationApplication.class, args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootPaginationApplication.class);
	}
}
