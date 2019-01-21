package com.zhangbin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${microservice.url}")
	private String prefixUrl; 
	
	@Value("${microservice.system}")
	private String systemUrl; 
	
	@GetMapping(value={"/","/login"})
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/index")
	public String index(Model model,@RequestParam("token")String token) {
		String url = prefixUrl+systemUrl+"/getAllMenu";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorication", token);
		HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<JSONObject> forObject = restTemplate.exchange(url, HttpMethod.GET, requestEntity , JSONObject.class);
		model.addAttribute("menus", forObject.getBody().get("data"));
		return "index";
	}
}
