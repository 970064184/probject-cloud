package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**自定义菜单查询接口返回数据组装
 * @author admin
 *
 */
public class OutWxMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OutWxConditionalMenu menu;
	
	@JSONField(name ="conditionalmenu")
	private List<OutWxConditionalMenu> conditionalMenu;

	public OutWxConditionalMenu getMenu() {
		return menu;
	}

	public void setMenu(OutWxConditionalMenu menu) {
		this.menu = menu;
	}
	
	@JSONField(name ="conditionalmenu")
	public List<OutWxConditionalMenu> getConditionalMenu() {
		return conditionalMenu;
	}

	public void setConditionalMenu(List<OutWxConditionalMenu> conditionalMenu) {
		this.conditionalMenu = conditionalMenu;
	}
	
	public OutWxMenu() {
		super();
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
//		return "OutWxMenu [menu=" + menu + ", conditionalMenu=" + conditionalMenu + "]";
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
}
