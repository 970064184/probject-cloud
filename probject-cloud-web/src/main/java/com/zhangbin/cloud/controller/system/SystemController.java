package com.zhangbin.cloud.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.service.SystemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "系统相关接口API")
@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	@ApiOperation(value ="获取所有菜单",notes = "获取所有菜单")
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu() {
		return DtoUtils.isSuccess(systemService.findAll());
	}
	
}
