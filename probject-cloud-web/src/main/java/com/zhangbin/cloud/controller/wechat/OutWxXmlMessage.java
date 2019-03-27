package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;


/**接收XML请求数据
 * @author admin
 *
 */
@XStreamAlias("xml")
public class OutWxXmlMessage implements Serializable{

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
  
  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String content;
  
}
