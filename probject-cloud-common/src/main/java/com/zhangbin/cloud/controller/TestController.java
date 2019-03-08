package com.zhangbin.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping("test")
	public Dto<String> test(){
		return DtoUtils.returnSuccess("hello");
	}
}
