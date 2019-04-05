package com.zhangbin.cloud.service.receivemsg;

import java.util.List;

import com.zhangbin.cloud.domain.receivemsg.Item;
import com.zhangbin.cloud.domain.receivemsg.OutWxXmlNewsMessage;
import com.zhangbin.cloud.domain.receivemsg.WxXmlMessage;

public interface WxNewsMsgService {
	/**
	 * 被动回复图文消息
	 * @param wxXmlMessage
	 * @return
	 */
	public OutWxXmlNewsMessage WxNewsMsgService(WxXmlMessage wxXmlMessage,List<Item> articles);
}
