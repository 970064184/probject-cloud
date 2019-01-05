package com.zhangbin.cloud.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试Controller的API")
@RestController
public class TestController {
	
	@ApiOperation(value = "测试接口", notes = "环境测试接口")
	@PostMapping(value="/test")
	public String test() {
		return "hello world！";
	}
	
}
