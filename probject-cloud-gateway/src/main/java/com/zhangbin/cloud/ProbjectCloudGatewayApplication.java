package com.zhangbin.cloud;
/**
 * 网关层主要功能
 * 1. 继承swagger2
 * 2. 鉴权、登录
 * 3. 服务降级与熔断
 * 4. 限流
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProbjectCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbjectCloudGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		return builder.routes().route(r->r.path("/jd").uri("http://jd.com:80/").id("jd_route")).build();

	}
}
