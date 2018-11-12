package com.zhangbin.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;

@FeignClient("microservice-provider-web")
public interface SystemFeignClient {
	
	@ApiOperation(value ="获取所有菜单",notes = "获取所有菜单")
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu();
}
