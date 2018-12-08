package com.zhangbin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${microservice.url}")
	private String prefixUrl; 
	
	@Value("${microservice.system}")
	private String systemUrl; 
	
	@RequestMapping("/index")
	public String index(Model model) {
		String url = prefixUrl+systemUrl+"/getAllMenu";
		JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
		model.addAttribute("menus", forObject.get("data"));
		return "index";
	}
}
