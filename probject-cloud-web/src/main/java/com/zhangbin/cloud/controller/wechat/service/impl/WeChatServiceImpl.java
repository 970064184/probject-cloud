package com.zhangbin.cloud.controller.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.controller.wechat.MiniProgram;
import com.zhangbin.cloud.controller.wechat.OutWxXmlMessage;
import com.zhangbin.cloud.controller.wechat.WxConstants;
import com.zhangbin.cloud.controller.wechat.WxTemplateData;
import com.zhangbin.cloud.controller.wechat.WxTemplateMessage;
import com.zhangbin.cloud.controller.wechat.WxXmlMessage;
import com.zhangbin.cloud.controller.wechat.service.WeChatService;
@Service
public class WeChatServiceImpl implements WeChatService {
	
	private static final Logger logger = LoggerFactory.getLogger("STORE");
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object handler(WxXmlMessage wxXmlMessage) {
		System.out.println(wxXmlMessage);
		OutWxXmlMessage out = new OutWxXmlMessage();
		//发送方
		out.setFromUserName(wxXmlMessage.getToUserName());
		//接收方
		out.setToUserName(wxXmlMessage.getFromUserName());
		out.setCreateTime(new Date().getTime());
		
		//判断消息类型是文本还是图片
		String msgType = wxXmlMessage.getMsgType();
		if(msgType.equals("text")) {
			sendTextMsg(wxXmlMessage,out);
		}else if(msgType.equals("event")) {
			sendEventMsg(wxXmlMessage,out);
		}
		return out;
	}

	private void sendEventMsg(WxXmlMessage wxXmlMessage,OutWxXmlMessage out) {
		logger.info("微信事件");
		String event = wxXmlMessage.getEvent();
		if(event.equals("subscribe")) {//
			out.setMsgType("text");
			out.setContent("感谢关注");
		}else if(event.equals("SCAN")) {
			WxTemplateMessage wx = new WxTemplateMessage();
			wx.setTouser(wxXmlMessage.getFromUserName());
			String template_id="MjmIqTXiig0MvFWCGS4B3nB7PcpJ_vv5VveYOyry40E";
			wx.setTemplate_id(template_id);
			MiniProgram miniprogram = new MiniProgram(WxConstants.APPID,WxConstants.PAGEPATH);
			wx.setMiniprogram(miniprogram );
			List<WxTemplateData> data = new ArrayList<>();
			data.add(new WxTemplateData("result", "测试成功", "#173177"));
			wx.setData(data);
			String accessToken="19_FGBv2J-AR1UCEAfxPFJUi2yMdzbwPmoAjTHyNGTxhES_8APIfuSG-XyAP4hDAAYItHyF-fPtuKtUYcko_qBnXfu-kVEyZmpvgjMv_Ywy8LqtZsbvJg97-op56EbQecItVh75TiRl6upHOPtPOVShAAARYV";
			String purl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
			ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(purl, wx, JSONObject.class);
			logger.info("模板消息发送返回值："+postForEntity);
			
		}
		
		
	}

	private void sendTextMsg(WxXmlMessage wxXmlMessage,OutWxXmlMessage out) {
		logger.info("微信文本");
		out.setMsgType("text");
//		String resContent = wxXmlMessage.getContent();
        String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\"href=\"http://www.qq.com\">智慧餐厅小程序</a>";
		out.setContent(resContent);
		
	}

}
