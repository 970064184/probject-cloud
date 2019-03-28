package com.zhangbin.cloud.service;

import com.zhangbin.cloud.domain.wechat.WxXmlMessage;

public interface WeChatService {
	/**
	 * 处理微信请求
	 * @param wxXmlMessage
	 * @return
	 */
	Object handler(WxXmlMessage wxXmlMessage);

}
