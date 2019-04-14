package com.zhangbin.cloud.service.receivemsg;

import com.zhangbin.cloud.domain.receivemsg.OutWxXmlTextMessage;
import com.zhangbin.cloud.domain.receivemsg.WxXmlMessage;

public interface WxTextMsgService {
	/**
	 * 被动回复文本消息
	 * @param wxXmlMessage
	 * @return
	 */
	public OutWxXmlTextMessage sendTextMsg(WxXmlMessage wxXmlMessage,String resContent);
}
