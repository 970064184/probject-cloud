package com.zhangbin.cloud.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.zhangbin.cloud.constant.WxMessageConstants;
import com.zhangbin.cloud.domain.wechat.Req.WxXmlMessage;
import com.zhangbin.cloud.domain.wechat.Resp.Item;
import com.zhangbin.cloud.domain.wechat.Resp.JaxbUtil;
import com.zhangbin.cloud.domain.wechat.Resp.OutWxXmlNewsMessage;
import com.zhangbin.cloud.service.SendNewsMsgService;
@Service
public class SendNewsMsgServiceImpl implements SendNewsMsgService {

	@Override
	public OutWxXmlNewsMessage sendNewsMsgService(WxXmlMessage wxXmlMessage) {
		OutWxXmlNewsMessage out = new OutWxXmlNewsMessage(wxXmlMessage);
		out.setMsgType(WxMessageConstants.NEWS.name());
		int articleCount=1;
		out.setArticleCount(articleCount);
//		Item(String title, String description, String picUrl, String url) 
		String resContent ="<a data-miniprogram-appid=\"wx4d9e4415bbb1ffab\" data-miniprogram-path=\"pages/customer/list/list\">智慧餐厅小程序</a>";
		out.setArticles(Arrays.asList(new Item("测试图文消息","测试回复图文消息","http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=1&spn=0&di=111426670960&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=935292084%2C2640874667&os=929535083%2C139004715&simid=3383873348%2C359765392&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fwww.pptok.com%2Fwp-content%2Fuploads%2F2012%2F08%2Fxunguang-4.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Brrp5h_z%26e3Bv54AzdH3F2sw6j-us5o-rrp-kwvh2657g1-rtvp76j_z%26e3Bip4s&gsm=0&islist=&querylist=",resContent)));
		String xmlContent = JaxbUtil.convertToXml (out);
		System.out.print(xmlContent);
		return out;
	}

}
