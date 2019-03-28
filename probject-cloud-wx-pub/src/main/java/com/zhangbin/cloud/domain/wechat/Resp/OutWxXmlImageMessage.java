package com.zhangbin.cloud.domain.wechat.Resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.zhangbin.cloud.domain.wechat.WxXmlMessage;


/**回复图片消息XML数据
 * @author admin
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutWxXmlImageMessage extends OutWxXmlMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**通过素材管理中的接口上传多媒体文件，得到的id。*/
	protected String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public OutWxXmlImageMessage() {
		super();
	}

	public OutWxXmlImageMessage(String toUserName, String fromUserName, Long createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public OutWxXmlImageMessage(WxXmlMessage wxXmlMessage) {
		super(wxXmlMessage);
	}

}
