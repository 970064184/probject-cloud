package com.zhangbin.cloud.service.sendmsg;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.domain.receivemsg.WxXmlMessage;
import com.zhangbin.cloud.domain.sendmsg.WxTemplateMessage;

public interface WxTemplateMsgService {
	/**
	 * 发送模板消息
	 * @param wxXmlMessage
	 * @param wxTemplateMessage
	 * @return
	 */
	public JSONObject sendTemplateMsg(WxXmlMessage wxXmlMessage,WxTemplateMessage wxTemplateMessage); 
}
