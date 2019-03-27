package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<WxTemplateData> data = new ArrayList<>();
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
	public List<WxTemplateData> getData() {
		return data;
	}
	public void setData(List<WxTemplateData> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "WxTemplateMessage [touser=" + touser + ", template_id=" + template_id + ", url=" + url
				+ ", miniprogram=" + miniprogram + ", data=" + data + "]";
	}
}
