package com.zhangbin.cloud.domain.sendmsg;

/**
 * @author admin
 *
 */
public class OutWxCustomMessage {
	
	private String touser;
	
	private String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	
	
}
