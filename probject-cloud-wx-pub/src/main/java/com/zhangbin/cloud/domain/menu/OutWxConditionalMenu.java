package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

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
	
//	@JSONField(name="matchrule")
	private WxMenuMatchRule matchrule;
	
//	@JSONField(name="menuid")
	private String menuid;

	public List<WxMenuButton> getButton() {
		return button;
	}

	public void setButton(List<WxMenuButton> button) {
		this.button = button;
	}

	public WxMenuMatchRule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(WxMenuMatchRule matchrule) {
		this.matchrule = matchrule;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	/*public String toJson() {
		return JSONObject.toJSONString(this);
	}*/

	@Override
	public String toString() {
		return "OutWxConditionalMenu [button=" + button + ", matchrule=" + matchrule + ", menuid=" + menuid + "]";
	}
}
