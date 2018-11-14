package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.zhangbin.cloud.feign")
@ComponentScan("com.zhangbin.cloud")
public class ProbjectCloudOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudBaseApplication.class, args);
	}
}
