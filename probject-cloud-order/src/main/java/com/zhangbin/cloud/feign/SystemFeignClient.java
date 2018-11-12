/*package com.zhangbin.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("microservice-provider-web")
public interface SystemFeignClient {
	
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu();
}
*/