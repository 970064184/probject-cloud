package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

public class WxTemplateValue implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String value;
	 private String color;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "WxTemplateData [value=" + value + ", color=" + color + "]";
	}
	public WxTemplateValue(String value, String color) {
		super();
		this.value = value;
		this.color = color;
	}
	
}
