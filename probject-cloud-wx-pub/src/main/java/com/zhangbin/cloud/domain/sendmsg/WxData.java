package com.zhangbin.cloud.domain.sendmsg;

import java.util.ArrayList;
import java.util.List;

/**消息模板
 * @author admin
 *
 */
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
