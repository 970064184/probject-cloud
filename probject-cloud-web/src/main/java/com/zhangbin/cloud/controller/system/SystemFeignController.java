package com.zhangbin.cloud.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.feign.SystemFeignClient;
import com.zhangbin.cloud.service.SystemService;

import io.swagger.annotations.Api;

@Api(tags = "系统相关接口API")
@RestController
public class SystemFeignController implements SystemFeignClient{
	
	@Autowired
	private SystemService systemService;
	
	@Override
	public String getAllMenu() {
		return DtoUtils.isSuccess(systemService.findAll());
	}
	
	
}
