package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.zhangbin.cloud.feign")
public class ProbjectCloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudOrderApplication.class, args);
	}
}
