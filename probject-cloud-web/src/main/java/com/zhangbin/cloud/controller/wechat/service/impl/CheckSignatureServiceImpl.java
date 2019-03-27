package com.zhangbin.cloud.controller.wechat.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.controller.wechat.Sha1Util;
import com.zhangbin.cloud.controller.wechat.WxConstants;
import com.zhangbin.cloud.controller.wechat.service.CheckSignatureService;
@Service
public class CheckSignatureServiceImpl implements CheckSignatureService{
	
	private static final Logger logger = LoggerFactory.getLogger("STORE");

	@Override
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
		//1）将token、timestamp、nonce三个参数进行字典序排序
    	String[] strArr = new String[]{WxConstants.TOKEN,timestamp,nonce};
    	logger.info("微信消息，传入参数："+strArr+";signature:"+signature+";echostr:"+echostr);
    	Arrays.sort(strArr);
    	StringBuffer content = new StringBuffer();
    	for (String str : strArr) {
    		content.append(str);
    	}
    	//2）将三个参数字符串拼接成一个字符串进行sha1加密
    	String sha1 = Sha1Util.getSha1(content.toString());
    	//第一次接入微信api接口时多传一个参数echostr
    	if (sha1.equals(signature) && !"".equals(echostr)) {
    		logger.info("第一次接入微信，传入参数："+strArr+";signature:"+signature+";echostr:"+echostr);
    		return echostr;
    	}
    	logger.info("第一次接入微信，接入失败");
    	return null;
	}

}
