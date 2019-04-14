package com.zhangbin.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.domain.sendmsg.OutWxCustomTextMessage;
import com.zhangbin.cloud.service.base.GetAccessTokenService;
import com.zhangbin.cloud.service.sendmsg.WxCustomMsgService;
@Service
public class WxCustomMsgServiceImpl implements WxCustomMsgService {
	
	@Autowired
	private GetAccessTokenService getAccessTokenService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public JSONObject sendCustomTextMsg(OutWxCustomTextMessage outWxCustomTextMessage) {
		String accessToken = getAccessTokenService.getAccessToken();
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(WxRequestUrl.MESSAGE_CUSTOM_SEND+accessToken, outWxCustomTextMessage, JSONObject.class);
		return postForEntity.getBody();
	}

}
