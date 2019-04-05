package com.zhangbin.cloud.domain.sendmsg;

import java.io.Serializable;

public class WxTemplateData implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private String color;

	  public WxTemplateData() {
	  }

	  public WxTemplateData(String name, String value) {
	    this.name = name;
	    this.value = value;
	  }

	  public WxTemplateData(String name, String value, String color) {
	    this.name = name;
	    this.value = value;
	    this.color = color;
	  }
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

	@Override
	public String toString() {
		return "WxTemplateData [name=" + name + ", value=" + value + ", color=" + color + "]";
	}
}
