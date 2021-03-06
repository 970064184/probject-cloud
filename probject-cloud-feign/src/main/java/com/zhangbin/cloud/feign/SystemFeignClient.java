package com.zhangbin.cloud.feign;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.domain.system.TbAuthority;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@FeignClient("microservice-provider-web")
public interface SystemFeignClient {
	
	@ApiOperation(value ="获取所有菜单",notes = "获取所有菜单")
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllMenu(HttpServletRequest request);
	
	@ApiOperation(value ="获取所有菜单2",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto getMenu();
	
	@ApiOperation(value ="获取所有菜单2",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu4",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<List<TbAuthority>> getMenu4();
	
	@ApiOperation(value ="获取所有菜单3",notes = "获取所有菜单")
	@GetMapping(value = "/getMenu3",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TbAuthority getMenu3();
}
