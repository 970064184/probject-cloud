package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**自定义菜单查询接口返回数据组装
 * @author admin
 *
 */
public class OutWxConditionalMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**一级菜单数组，个数为1~3个*/
	private List<WxMenuButton> button;
	
	@JSONField(name="matchrule")
	private WxMenuMatchRule matchRule;
	
	@JSONField(name="menuid")
	private String menuId;

	public List<WxMenuButton> getButton() {
		return button;
	}

	public void setButton(List<WxMenuButton> button) {
		this.button = button;
	}

	public WxMenuMatchRule getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(WxMenuMatchRule matchRule) {
		this.matchRule = matchRule;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
//		return "OutWxConditionalMenu [button=" + button + ", matchRule=" + matchRule + ", menuId=" + menuId + "]";
	}

	public String toJson() {
		return JSONObject.toJSONString(this);
	}

	public static void main(String[] args) {
		OutWxConditionalMenu outWxConditionalMenu = new OutWxConditionalMenu();
		outWxConditionalMenu.setMenuId("test123");
		System.out.println(outWxConditionalMenu.toJson());
	}
}
