package com.zhangbin.cloud.controller.test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.domain.test.Test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "测试Controller的API")
@RestController
public class TestController {
	
	@ApiOperation(value = "测试接口", notes = "环境测试接口")
	@PostMapping(value="/test")
	public String test() {
		return "hello world！";
	}
	
	@ApiOperation(value = "测试获取url上的参数值", notes = "测试获取url上的参数值，返回，例如http://localhost:7900/getPathVariable/221212")
	@GetMapping(value="/getPathVariable/{param}")
	public int test1(@ApiParam(value = "参数",required = true)@PathVariable("param")Integer param) {
		return param;
	}
	
	@ApiOperation(value = "测试获取请求参数的参数值", notes = "测试获取请求参数的参数值，返回，例如http://localhost:7900/getRequestParam?param=223233")
	@GetMapping(value="/getRequestParam")
	public int test2(@ApiParam(value = "参数",required = true)@RequestParam("param")Integer param) {
		return param;
	}
	
	@ApiOperation(value = "测试结果返回格式", notes = "测试获取请求参数的参数值，返回json格式")
	@GetMapping(value="/testDtoResult",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test3(@ApiParam(value = "参数",required = true)@RequestParam("param")Integer param) {
//		return new Dto("000000","成功",param);
//		return DtoUtils.isSuccess();
		return DtoUtils.isSuccess(param);
	}
	
	@ApiOperation(value = "测试json格式请求",notes = "测试json格式请求,返回json格式")
	@PostMapping(value = "/postByJson",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test3(@RequestBody Test test) {
		return DtoUtils.isSuccess(test);
	}
	
	@ApiOperation(value = "获取所有状态码",notes = "获取系统所有状态码")
	@GetMapping(value = "/getAllCode",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test4() {
		return DtoUtils.isSuccess(CodeEnum.values());
	}
	
	
}
