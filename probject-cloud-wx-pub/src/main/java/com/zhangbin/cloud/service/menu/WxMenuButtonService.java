package com.zhangbin.cloud.service.menu;

import com.alibaba.fastjson.JSONObject;
import com.zhangbin.cloud.domain.menu.WxMenu;

/**微信自定义菜单
 * @author admin
 *
 */
public interface WxMenuButtonService {
	
	/**
	 * 自定义菜单创建接口
	 * @param wxMenu
	 * @return
	 */
	JSONObject createMenu(WxMenu wxMenu);
	/**
	 * 自定义菜单查询接口
	 * @return
	 */
	String getMenu();
	
}
