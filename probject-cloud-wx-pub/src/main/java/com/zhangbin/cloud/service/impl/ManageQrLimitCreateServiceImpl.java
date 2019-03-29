package com.zhangbin.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zhangbin.cloud.constant.WxRequestUrl;
import com.zhangbin.cloud.domain.wechat.Req.ManageQrLimitCreate;
import com.zhangbin.cloud.domain.wechat.Resp.OutManageQrLimitCreate;
import com.zhangbin.cloud.service.GetAccessToken;
import com.zhangbin.cloud.service.ManageQrLimitCreateService;
@Service
public class ManageQrLimitCreateServiceImpl implements ManageQrLimitCreateService {
	
	@Autowired
	private GetAccessToken getAccessToken;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public OutManageQrLimitCreate create(ManageQrLimitCreate manageQrLimitCreate) {
		OutManageQrLimitCreate out = new OutManageQrLimitCreate(); 
		String accessToken = getAccessToken.getAccessToken();
		ResponseEntity<OutManageQrLimitCreate> postForEntity = restTemplate.postForEntity(WxRequestUrl.QRCODE_CREATE+accessToken, manageQrLimitCreate, OutManageQrLimitCreate.class);
		out = postForEntity.getBody();
		return out;
	}

	@Override
	public void showqrcode(OutManageQrLimitCreate out) {
		restTemplate.getForEntity(WxRequestUrl.SHOWQRCODE+out.getTicket(), Object.class);
	}

}
