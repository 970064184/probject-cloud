package com.zhangbin.cloud.test;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.conf.MyShiroRealm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试Controller的API")
@RestController
public class TestController {
	
	@ApiOperation(value = "测试接口", notes = "环境测试接口")
	@GetMapping(value="/test")
//	@RequiresRoles("002")
	public String test() {
		Long long1 = MyShiroRealm.THREADLOCAL.get();
		System.out.println(long1);
		return "hello world！";
	}
	
}
