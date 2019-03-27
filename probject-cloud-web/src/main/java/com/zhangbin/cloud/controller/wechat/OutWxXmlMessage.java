package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

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
	
	  protected String ToUserName;
	
	  protected String FromUserName;
	
	  protected Long CreateTime;
	
	  protected String MsgType;
	  
	  protected String Content;

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

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "OutWxXmlMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Content=" + Content + "]";
	}
}
