package com.zhangbin.cloud.controller.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.feign.SystemFeignClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="订单管理API")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private SystemFeignClient systemFeignClient;
	
	@ApiOperation(value = "请求系统数据",notes = "订单系统要请求系统数据")
	@GetMapping(value = "/getSystemData",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getSystemData() {
		return DtoUtils.isSuccess(restTemplate.getForObject("http://localhost:8040/microservice-provider-web/system/getAllMenu",JSONObject.class));
	}
	
	@ApiOperation(value = "服务间请求系统数据",notes = "订单系统要请求系统数据")
	@GetMapping(value = "/getAllMenu",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu() {
		JSONObject allMenu =JSONObject.parseObject(systemFeignClient.getAllMenu());
		return DtoUtils.isSuccess(allMenu.get("data"));
//		return systemFeignClient.getAllMenu();
	}
	
}
