package com.zhangbin.cloud.service;

import com.zhangbin.cloud.domain.wechat.WxXmlMessage;
import com.zhangbin.cloud.domain.wechat.Resp.OutWxXmlTextMessage;

public interface SendTextMsgService {
	/**
	 * 被动回复文本消息
	 * @param wxXmlMessage
	 * @return
	 */
	public OutWxXmlTextMessage sendTextMsg(WxXmlMessage wxXmlMessage);
}
