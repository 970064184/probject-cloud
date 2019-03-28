package com.zhangbin.cloud.domain.wechat;

import java.io.Serializable;
import java.util.Map;

/**消息模板返回参数
 * @author Administrator
 *
 */
public class WxTemplateMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**接收者openid*/
	private String touser;
	/**模板id*/
	private String template_id;
	/**模板跳转url*/
	private String url;
	private MiniProgram miniprogram;
	
	private Map<String,WxTemplateValue> data;
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public MiniProgram getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(MiniProgram miniprogram) {
		this.miniprogram = miniprogram;
	}
	public Map<String, WxTemplateValue> getData() {
		return data;
	}
	public void setData(Map<String, WxTemplateValue> data) {
		this.data = data;
	}
	public WxTemplateMessage(String touser, String template_id, String url, MiniProgram miniprogram,
			Map<String, WxTemplateValue> data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.miniprogram = miniprogram;
		this.data = data;
	}
	public WxTemplateMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
}
