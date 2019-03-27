package com.zhangbin.cloud.controller.wechat;

import java.io.Serializable;

public class WxTemplateData implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	 private String value;
	 private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public WxTemplateData(String name, String value, String color) {
		super();
		this.name = name;
		this.value = value;
		this.color = color;
	}
	@Override
	public String toString() {
		return "WxTemplateData [name=" + name + ", value=" + value + ", color=" + color + "]";
	}
}
