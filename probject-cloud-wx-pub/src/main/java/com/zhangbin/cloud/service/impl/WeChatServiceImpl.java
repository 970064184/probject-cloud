package com.zhangbin.cloud.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.conf.redis.RedisService;
import com.zhangbin.cloud.constant.WxConstants;
import com.zhangbin.cloud.domain.receivemsg.Item;
import com.zhangbin.cloud.domain.receivemsg.OutWxXmlMessage;
import com.zhangbin.cloud.domain.receivemsg.WxXmlMessage;
import com.zhangbin.cloud.domain.sendmsg.WxTemplateMessage;
import com.zhangbin.cloud.domain.sendmsg.WxTemplateValue;
import com.zhangbin.cloud.service.WeChatService;
import com.zhangbin.cloud.service.receivemsg.WxNewsMsgService;
import com.zhangbin.cloud.service.receivemsg.WxTextMsgService;
@Service
public class WeChatServiceImpl implements WeChatService {

	private static final Logger logger = LoggerFactory.getLogger("STORE");

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RedisService jedisCluster;
	@Autowired
	private WxTextMsgService sendTextMsgService;
	@Autowired
	private WxNewsMsgService sendNewsMsgService;

	@Override
	public Object handler(WxXmlMessage wxXmlMessage) {
		System.out.println(wxXmlMessage);
		OutWxXmlMessage out = new OutWxXmlMessage();
		//发送方
		/*	out.setFromUserName(wxXmlMessage.getToUserName());
		//接收方
		out.setToUserName(wxXmlMessage.getFromUserName());
		out.setCreateTime(new Date().getTime());*/

		//判断消息类型是文本还是图片
		String msgType = wxXmlMessage.getMsgType();
		if(msgType.equals("text")) {
			if(wxXmlMessage.getContent().equals("好")) {
				String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\">智慧餐厅小程序</a>";
				List<Item> asList = Arrays.asList(new Item("测试图文消息","测试回复图文消息","http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=1&spn=0&di=111426670960&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=935292084%2C2640874667&os=929535083%2C139004715&simid=3383873348%2C359765392&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fwww.pptok.com%2Fwp-content%2Fuploads%2F2012%2F08%2Fxunguang-4.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Brrp5h_z%26e3Bv54AzdH3F2sw6j-us5o-rrp-kwvh2657g1-rtvp76j_z%26e3Bip4s&gsm=0&islist=&querylist=",resContent));
				out = sendNewsMsgService.WxNewsMsgService(wxXmlMessage,asList);
			}else {
				String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\">智慧餐厅小程序</a>";
				out = sendTextMsgService.sendTextMsg(wxXmlMessage,resContent);
			}
		}else if(msgType.equals("event")) {
			sendEventMsg(wxXmlMessage,out);
		}
		System.out.println("微信被动回复消息："+out);
		return out;
	}

	private void sendEventMsg(WxXmlMessage wxXmlMessage,OutWxXmlMessage out) {
		logger.info("微信事件");
		String event = wxXmlMessage.getEvent();
		if(event.equals("subscribe")) {//
			/*out.setMsgType("text");
			out.setContent("感谢关注");*/
			sendTemplateMessage(wxXmlMessage);
		}else if(event.equals("SCAN")) {
			sendTemplateMessage(wxXmlMessage);
		}
	}
	/**
	 * 发送消息模板
	 * @param wxXmlMessage
	 */
	private void sendTemplateMessage(WxXmlMessage wxXmlMessage) {
		logger.info("发送消息模板");
		WxTemplateMessage wx = new WxTemplateMessage();
		wx.setTouser(wxXmlMessage.getFromUserName());
		String template_id="o0GNY6wUgIEnfQ0zJwbjRNL4hQfgLVUsMgMonGBjyb0";
		wx.setTemplate_id(template_id);
		String eventKey = wxXmlMessage.getEventKey();
//		List<WxTemplateData> data = new ArrayList<>();
//		MiniProgram miniprogram = new MiniProgram(WxConstants.WX_SMALL_APPID,WxConstants.WX_SMALL_PAGEPATH+eventKey);
//		wx.setMiniprogram(miniprogram );
		Map<String, WxTemplateValue> data = new HashMap<>();
		data.put("key1", new WxTemplateValue("石牌肠粉", "#173177"));
		data.put("key2", new WxTemplateValue("8", "#173177"));
		data.put("key3", new WxTemplateValue("欢迎访问互联网家", "#C0C0C0"));
		data.put("key4", new WxTemplateValue("<img src=\"http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=1&spn=0&di=111426670960&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=935292084%2C2640874667&os=929535083%2C139004715&simid=3383873348%2C359765392&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fwww.pptok.com%2Fwp-content%2Fuploads%2F2012%2F08%2Fxunguang-4.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Brrp5h_z%26e3Bv54AzdH3F2sw6j-us5o-rrp-kwvh2657g1-rtvp76j_z%26e3Bip4s&gsm=0&islist=&querylist=\"  alt=\"上海鲜花港 - 郁金香\" />", "#173177"));
		wx.setData(data);
		String accessToken = getAccessToken();
		String purl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
		logger.info("模板消息发送发送值1："+JSONObject.toJSONString(wx));
		logger.info("模板消息发送发送值2："+JSONArray.toJSONString(wx));
		ResponseEntity<JSONObject> postForEntity = restTemplate.postForEntity(purl, wx, JSONObject.class);
		logger.info("模板消息发送返回值："+postForEntity);
	}
	/**
	 * 被动回复文本消息
	 * @param wxXmlMessage
	 * @param out
	 */
/*	private void sendTextMsg(WxXmlMessage wxXmlMessage,OutWxXmlMessage out) {
		logger.info("微信文本");
		out.setMsgType("text");
//		String resContent = wxXmlMessage.getContent();
        String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\"href=\"http://www.qq.com\">智慧餐厅小程序</a>";
		out.setContent(resContent);
	}*/

	/**
	 * 获取access_token接口
	 * @return
	 */
	private String getAccessToken(){
		logger.info("获取access_token接口");
		String redisKey = WxConstants.SRT_SHOP_WX_ACCESS_TOKEN;
		String accessToken="20_6c2KxDUqY28W6W9jvOMVPADzoS2Rj3KmTMU9X7xAjehzqQlzj5ZQjKUmgPYVtddINDN4XTBoNAyyATCHPBlfMU7BxsQINdp2FMy1mx49Yb-4pUMcYJ7dQhf_QKYBWXjAGAGBC";
		/*try {
			accessToken = jedisCluster.get(WxKey.token,redisKey,String.class);
			logger.info("获取redis上的access_token：",accessToken);
			if("".equals(accessToken)){
				logger.info("请求微信获取access_token：",accessToken);
				String appid=WxConstants.WX_PUB_APPID;
				String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+WxConstants.WX_PUB_SECRET;
				ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class);
				logger.info("请求微信获取access_token返回值",forEntity);
				JSONObject body = forEntity.getBody();
				accessToken = body.get("access_token").toString();
				jedisCluster.set(WxKey.token,redisKey, accessToken);
			}
			logger.info("获取access_token：",accessToken);
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取access_token接口异常");
		}*/
		return accessToken;
	}

}
