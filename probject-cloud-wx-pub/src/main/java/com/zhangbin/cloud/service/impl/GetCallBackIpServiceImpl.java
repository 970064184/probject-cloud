package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.service.base.GetAccessTokenService;
import com.zhangbin.cloud.service.base.GetCallBackIpService;
@Service
public class GetCallBackIpServiceImpl implements GetCallBackIpService {
	
	@Autowired
	private GetAccessTokenService getAccessTokenService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<String> getCallBackIp() {
		List<String> list = new ArrayList<>();
		String accessToken = getAccessTokenService.getAccessToken();
		ResponseEntity<JSONArray> forEntity = restTemplate.getForEntity(WxRequestUrl.GETCALLBACKIP+accessToken, JSONArray.class);
		list = JSONObject.parseArray(forEntity.getBody().toJSONString(),String.class);
		return list;
	}

}
