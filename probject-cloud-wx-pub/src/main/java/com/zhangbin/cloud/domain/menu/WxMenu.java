package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

/**自定义创建微信菜单
 * @author admin
 *
 */
public class WxMenu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**一级菜单数组，个数为1~3个*/
	private List<WxMenuButton> button;
	
	public List<WxMenuButton> getButton() {
		return button;
	}

	public void setButton(List<WxMenuButton> button) {
		this.button = button;
	}

	public WxMenu() {
		super();
	}

	public WxMenu(List<WxMenuButton> button) {
		super();
		this.button = button;
	}
}
