package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


/**接收XML请求数据
 * @author admin
 *
 */
@XStreamAlias("xml")
public class WxXmlMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  @XStreamAlias("ToUserName")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String toUserName;
	
	  @XStreamAlias("FromUserName")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String fromUserName;
	
	  @XStreamAlias("CreateTime")
	  protected Long createTime;
	
	  @XStreamAlias("MsgType")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String msgType;
	  
	  @XStreamAlias("MsgId")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String msgId;
	  
	  @XStreamAlias("Content")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String content;
	  
	  @XStreamAlias("Event")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String event;
	  
	  @XStreamAlias("EventKey")
	  @XStreamConverter(value = XStreamCDataConverter.class)
	  protected String eventKey;

	public String getToUserName() {
		return toUserName;
	}
	
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	public String getFromUserName() {
		return fromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	public Long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	public String getMsgType() {
		return msgType;
	}
	
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public String getMsgId() {
		return msgId;
	}
	
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public String getEventKey() {
		return eventKey;
	}
	
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	@Override
	public String toString() {
		return "WxXmlMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", msgType=" + msgType + ", msgId=" + msgId + ", content=" + content + ", event=" + event
				+ ", eventKey=" + eventKey + "]";
	}
	  
}
