package com.example.swpumapserv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.example.swpumapserv.mapper"})
public class SwpumapservApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwpumapservApplication.class, args);
	}
}
