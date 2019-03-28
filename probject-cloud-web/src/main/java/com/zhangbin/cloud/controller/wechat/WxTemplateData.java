package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

public class WxTemplateData implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private WxTemplateValue wxTemplateValue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WxTemplateValue getWxTemplateValue() {
		return wxTemplateValue;
	}
	public void setWxTemplateValue(WxTemplateValue wxTemplateValue) {
		this.wxTemplateValue = wxTemplateValue;
	}
	public WxTemplateData(String name, WxTemplateValue wxTemplateValue) {
		super();
		this.name = name;
		this.wxTemplateValue = wxTemplateValue;
	}
	@Override
	public String toString() {
		return "WxTemplateDate [name=" + name + ", wxTemplateValue=" + wxTemplateValue + "]";
	}
	
}
