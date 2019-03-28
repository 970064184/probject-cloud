package com.zhangbin.cloud.service.impl;

import org.springframework.stereotype.Service;

import com.zhangbin.cloud.constant.WxMessageConstants;
import com.zhangbin.cloud.domain.wechat.WxXmlMessage;
import com.zhangbin.cloud.domain.wechat.Resp.OutWxXmlTextMessage;
import com.zhangbin.cloud.service.SendTextMsgService;
@Service
public class SendTextMsgServiceImpl implements SendTextMsgService{

	@Override
	public OutWxXmlTextMessage sendTextMsg(WxXmlMessage wxXmlMessage) {
		OutWxXmlTextMessage out = new OutWxXmlTextMessage(wxXmlMessage);
		out.setMsgType(WxMessageConstants.TEXT.name());
		String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\"href=\"http://www.qq.com\">智慧餐厅小程序</a>";
		out.setContent(resContent);
		return out;
	}

}
