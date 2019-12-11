package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients("com.zhangbin.cloud.feign")
public class ProbjectCloudGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudGatewayZuulApplication.class, args);
	}
}
