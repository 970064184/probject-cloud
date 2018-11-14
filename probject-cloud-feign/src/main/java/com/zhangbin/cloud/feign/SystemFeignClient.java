package com.zhangbin.cloud.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.domain.system.TbMenu;

import io.swagger.annotations.ApiOperation;

@FeignClient("microservice-provider-web")
public interface SystemFeignClient {
	
	@ApiOperation(value ="获取所有菜单",notes = "获取所有菜单")
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu();
	
	@ApiOperation(value ="获取所有菜单2",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto getMenu();
	
	@ApiOperation(value ="获取所有菜单2",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu4",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<List<TbMenu>> getMenu4();
	
	@ApiOperation(value ="获取所有菜单3",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu3",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TbMenu getMenu3();
}
