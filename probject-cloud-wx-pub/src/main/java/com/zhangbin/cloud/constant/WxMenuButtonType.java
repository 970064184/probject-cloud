package com.zhangbin.cloud.constant;

/**自定义菜单接口可实现多种类型按钮
 * @author admin
 *
 */
public enum WxMenuButtonType {
	CLICK("click"),
	
	VIEW("view"),
	
	SCANCODE_PUSH("scancode_push"),
	
	SCANCODE_WAITMSG("scancode_waitmsg"),
	
	PIC_SYSPHOTO("pic_sysphoto"),
	
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
	
	PIC_WEIXIN("pic_weixin"),
	
	LOCATION_SELECT("location_select"),
	
	MEDIA_ID("media_id"),
	
	VIEW_LIMITED("view_limited");
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private WxMenuButtonType(String type) {
		this.type = type;
	}
	
}
