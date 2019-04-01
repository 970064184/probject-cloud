package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**微信菜单
 * @author admin
 *
 */
public class WxMenuButton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**菜单的响应动作类型（WxMenuButtonType），view表示网页类型，click表示点击类型，miniprogram表示小程序类型*/
	private String type;
	/**菜单标题*/
	private String name;
	/**click等点击类型*/
	private String key;
	/**网页链接*/
	private String url;
	/**小程序APPID*/
	@JSONField(name = "appid")
	private String appId;
	/**小程序页面路径*/
	@JSONField(name = "pagepath")
	private String pagePath;
	/**调用新增永久素材接口返回的合法media_id*/
	@JSONField(name = "media_id")
	private String mediaId;
	
	/**二级菜单数组，个数为1~5个*/
	@JSONField(name = "sub_button")
	private List<WxMenuButton> subButton;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	@JSONField(name = "sub_button")
	public List<WxMenuButton> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<WxMenuButton> subButton) {
		this.subButton = subButton;
	}

	@Override
	public String toString() {
//		return "WxMenuButton [type=" + type + ", name=" + name + ", key=" + key + ", url=" + url + ", appId=" + appId
//				+ ", pagePath=" + pagePath + ", subButton=" + subButton + "]";
		return JSONObject.toJSONString(this);
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
}
