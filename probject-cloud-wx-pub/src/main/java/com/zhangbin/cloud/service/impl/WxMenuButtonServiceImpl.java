package com.zhangbin.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.domain.menu.OutWxMenu;
import com.zhangbin.cloud.domain.menu.WxMenu;
import com.zhangbin.cloud.service.base.GetAccessTokenService;
import com.zhangbin.cloud.service.menu.WxMenuButtonService;
@Service
public class WxMenuButtonServiceImpl implements WxMenuButtonService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private GetAccessTokenService getAccessTokenService;
	
	@Override
	public JSONObject createMenu(WxMenu wxMenu) {
		String accessToken = getAccessTokenService.getAccessToken();
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(WxRequestUrl.MENU_CREATE+accessToken, wxMenu, JSONObject.class);
		return postForEntity.getBody();
	}

	@Override
	public String getMenu() {
		String accessToken = getAccessTokenService.getAccessToken();
		ResponseEntity<OutWxMenu> forEntity = restTemplate.getForEntity(WxRequestUrl.MENU_GET+accessToken, OutWxMenu.class);
		String json = forEntity.getBody().toString();
		return json;
	}

}
