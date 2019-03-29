package com.zhangbin.cloud.domain.wechat.Req;

import java.io.Serializable;

/**生成二维码请求参数
 * @author admin
 *
 */
public class ManageQrLimitCreate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**该二维码有效时间*/
	private String expire_seconds;
	/**二维码类型：QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值*/
	private String action_name;
	/**二维码详细信息*/
	private Scene action_info;
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public Scene getAction_info() {
		return action_info;
	}
	public void setAction_info(Scene action_info) {
		this.action_info = action_info;
	}
}
