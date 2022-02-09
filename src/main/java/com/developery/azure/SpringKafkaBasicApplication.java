package com.developery.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringKafkaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaBasicApplication.class, args);
	}

}
