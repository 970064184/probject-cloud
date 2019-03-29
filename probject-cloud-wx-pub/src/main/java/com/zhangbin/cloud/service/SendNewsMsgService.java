package com.zhangbin.cloud.service;

import com.zhangbin.cloud.domain.wechat.Req.WxXmlMessage;
import com.zhangbin.cloud.domain.wechat.Resp.OutWxXmlNewsMessage;

public interface SendNewsMsgService {
	/**
	 * 被动回复图文消息
	 * @param wxXmlMessage
	 * @return
	 */
	public OutWxXmlNewsMessage sendNewsMsgService(WxXmlMessage wxXmlMessage);
}
