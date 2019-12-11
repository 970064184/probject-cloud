package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.zhangbin.cloud.feign")
@SpringBootApplication
public class ProbjectCloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudUserApplication.class, args);
	}
}
