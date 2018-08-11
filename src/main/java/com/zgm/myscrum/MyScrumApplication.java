package com.zgm.myscrum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zgm.myscrum.dao")
public class MyScrumApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyScrumApplication.class, args);
	}
}
