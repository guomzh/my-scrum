package com.zgm.myscrum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.zgm.myscrum.dao")
public class MyScrumApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MyScrumApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
           return builder.sources(MyScrumApplication.class);
	}
}
