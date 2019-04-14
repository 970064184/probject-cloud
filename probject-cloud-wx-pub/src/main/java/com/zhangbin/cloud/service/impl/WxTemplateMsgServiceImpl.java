package com.zhangbin.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.domain.receivemsg.WxXmlMessage;
import com.zhangbin.cloud.domain.sendmsg.WxTemplateMessage;
import com.zhangbin.cloud.service.base.GetAccessTokenService;
import com.zhangbin.cloud.service.sendmsg.WxTemplateMsgService;
@Service
public class WxTemplateMsgServiceImpl implements WxTemplateMsgService{
	
	@Autowired
	private GetAccessTokenService accessTokenService;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public JSONObject sendTemplateMsg(WxXmlMessage wxXmlMessage, WxTemplateMessage wxTemplateMessage) {
		String accessToken = accessTokenService.getAccessToken();
		wxTemplateMessage.setTouser(wxXmlMessage.getFromUserName());
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(WxRequestUrl.MESSAGE_TEMPLATE_SEND+accessToken, wxTemplateMessage, JSONObject.class);
		return postForEntity.getBody();
	}

}
