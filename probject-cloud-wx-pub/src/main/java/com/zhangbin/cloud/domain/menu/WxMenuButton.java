package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

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
	private String appid;
	/**小程序页面路径*/
	private String pagepath;
	/**调用新增永久素材接口返回的合法media_id*/
	private String media_id;
	
	/**二级菜单数组，个数为1~5个*/
//	@JSONField(name="sub_button")
	private List<WxMenuButton> sub_button;

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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public List<WxMenuButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WxMenuButton> sub_button) {
		this.sub_button = sub_button;
	}

	/*public void setSub_button(List<WxMenuButton> sub_button) {
		this.subButton = sub_button;
	}*/
}
