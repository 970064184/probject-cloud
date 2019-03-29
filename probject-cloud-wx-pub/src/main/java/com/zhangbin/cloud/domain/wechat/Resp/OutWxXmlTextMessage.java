package com.zhangbin.cloud.domain.wechat.Resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.zhangbin.cloud.domain.wechat.Req.WxXmlMessage;


/**返回文本消息XML数据
 * @author admin
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutWxXmlTextMessage extends OutWxXmlMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  /**回复的消息内容*/
	  protected String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public OutWxXmlTextMessage() {
		super();
	}

	public OutWxXmlTextMessage(String toUserName, String fromUserName, Long createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public OutWxXmlTextMessage(WxXmlMessage wxXmlMessage) {
		super(wxXmlMessage);
	}

}
