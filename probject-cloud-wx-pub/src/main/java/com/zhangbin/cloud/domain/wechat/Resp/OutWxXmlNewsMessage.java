package com.zhangbin.cloud.domain.wechat.Resp;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.zhangbin.cloud.domain.wechat.WxXmlMessage;


/**返回图文消息XML数据
 * @author admin
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutWxXmlNewsMessage extends OutWxXmlMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**图文消息个数*/
	protected int ArticleCount;
	/**图文消息信息*/
	@XmlElementWrapper(name="Articles")
    @XmlElement(name="item")
	List<Item> Articles = new ArrayList<>();
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Item> getArticles() {
		return Articles;
	}
	public void setArticles(List<Item> articles) {
		Articles = articles;
	}
	public OutWxXmlNewsMessage() {
		super();
	}
	public OutWxXmlNewsMessage(String toUserName, String fromUserName, Long createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}
	public OutWxXmlNewsMessage(WxXmlMessage wxXmlMessage) {
		super(wxXmlMessage);
	}
	@Override
	public String toString() {
		return "OutWxXmlNewsMessage [ArticleCount=" + ArticleCount + ", Articles=" + Articles + "]";
	}
}
