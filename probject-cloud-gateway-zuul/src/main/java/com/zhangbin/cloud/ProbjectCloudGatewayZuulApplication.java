package com.zhangbin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients("com.zhangbin.cloud.feign")
public class ProbjectCloudGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudGatewayZuulApplication.class, args);
	}
}
