package com.zhangbin.cloud.domain.receivemsg;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**接收XML请求数据
 * @author admin
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutWxXmlMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  /**接收方账号*/
	  protected String ToUserName;
	  /**开发者微信号*/
	  protected String FromUserName;
	  /**消息创建时间*/
	  protected Long CreateTime;
	  /**消息类型*/
	  protected String MsgType;
	  
	public OutWxXmlMessage() {
		super();
	}
	
	public OutWxXmlMessage(WxXmlMessage wxXmlMessage) {
		super();
		ToUserName = wxXmlMessage.getFromUserName();
		FromUserName = wxXmlMessage.getToUserName();
		CreateTime = new Date().getTime();
	}
	public OutWxXmlMessage(String toUserName, String fromUserName, Long createTime, String msgType) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	}

	public String getToUserName() {
		return ToUserName;
	}
	
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
