package com.zhangbin.cloud.domain.sendmsg;

/**客服消息-发文本消息的内容
 * @author admin
 *
 */
public class OutWxCustomTextMessageContent {
	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OutWxCustomTextMessageContent(String content) {
		super();
		this.content = content;
	}

	public OutWxCustomTextMessageContent() {
		super();
	}

	@Override
	public String toString() {
		return "OutWxCustomTextMessageContent [content=" + content + "]";
	}
	
}
