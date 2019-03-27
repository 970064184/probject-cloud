package com.zhangbin.cloud.controller.wechat.service;

import com.zhangbin.cloud.controller.wechat.WxXmlMessage;

public interface WeChatService {
	/**
	 * 处理微信请求
	 * @param wxXmlMessage
	 * @return
	 */
	Object handler(WxXmlMessage wxXmlMessage);

}
