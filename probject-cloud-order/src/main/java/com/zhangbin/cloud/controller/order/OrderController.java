package com.zhangbin.cloud.controller.order;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zhangbin.cloud.common.Dto;
import com.zhangbin.cloud.common.DtoUtils;
import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.domain.system.TbMenu;
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
	public String getAllMenu(HttpServletRequest request) {
		JSONObject allMenu =JSONObject.parseObject(systemFeignClient.getAllMenu(request));
		return DtoUtils.isSuccess(allMenu.get("data"));
//		return systemFeignClient.getAllMenu();
	}
	
	@ApiOperation(value = "服务间请求系统数据",notes = "订单系统要请求系统数据")
	@GetMapping(value = "/getAllMenu2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu2() {
		/*Dto allMenu2 = systemFeignClient.getAllMenu2();
		Object data = allMenu2.getData();
		System.out.println(data);*/
		System.out.println("come");
		Dto menu = systemFeignClient.getMenu();
		List<TbMenu> parseArray = new ArrayList<>();
		parseArray = (List<TbMenu>)menu.getData();//JSONArray.parseArray(menu.getData(), new TypeReference<List<TbMenu>>() {});
//		List<TbMenu> parseArray = (menu.getData().toString(),new TypeReference<List<TbMenu>>() {});
		return DtoUtils.isSuccess(parseArray);
	}
	@ApiOperation(value = "服务间请求系统数据",notes = "订单系统要请求系统数据")
	@GetMapping(value = "/getAllMenu4",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAllMenu4() {
		 Dto<List<TbAuthority>> menu4 = systemFeignClient.getMenu4();
		 List<TbAuthority> data = menu4.getData();
		 return DtoUtils.isSuccess(data);
	}
	
	@ApiOperation(value = "服务间请求系统数据",notes = "订单系统要请求系统数据")
	@GetMapping(value = "/getAllMenu5",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dto<List<TbAuthority>> getAllMenu5() {
		Dto<List<TbAuthority>> menu4 = systemFeignClient.getMenu4();
		List<TbAuthority> data = menu4.getData();
		return menu4;
	}
	
}
