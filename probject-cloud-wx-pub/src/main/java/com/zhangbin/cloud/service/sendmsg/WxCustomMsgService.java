package com.zhangbin.cloud.service.sendmsg;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.domain.sendmsg.OutWxCustomTextMessage;

/**客服消息
 * @author admin
 *
 */
public interface WxCustomMsgService {
	
	JSONObject sendCustomTextMsg(OutWxCustomTextMessage outWxCustomTextMessage);
	
}
