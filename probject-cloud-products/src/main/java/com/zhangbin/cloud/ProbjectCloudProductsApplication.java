package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
public class ProbjectCloudProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudProductsApplication.class, args);
	}
}
