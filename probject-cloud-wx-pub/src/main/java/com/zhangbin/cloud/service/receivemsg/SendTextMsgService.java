package com.zhangbin.cloud.service.receivemsg;

import com.zhangbin.cloud.domain.wechat.Req.WxXmlMessage;
import com.zhangbin.cloud.domain.wechat.Resp.OutWxXmlTextMessage;

public interface SendTextMsgService {
	/**
	 * 被动回复文本消息
	 * @param wxXmlMessage
	 * @return
	 */
	public OutWxXmlTextMessage sendTextMsg(WxXmlMessage wxXmlMessage);
}
