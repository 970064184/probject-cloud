package com.zhangbin.cloud.domain.wechat;

import java.util.ArrayList;
import java.util.List;

public class WxData {
	
	private List<WxTemplateData> data = new ArrayList<>();

	public List<WxTemplateData> getData() {
		return data;
	}

	public void setData(List<WxTemplateData> data) {
		this.data = data;
	}

	public WxData(List<WxTemplateData> data) {
		super();
		this.data = data;
	}
	
}
