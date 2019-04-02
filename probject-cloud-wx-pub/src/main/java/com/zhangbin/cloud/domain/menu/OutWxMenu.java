package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;
import java.util.List;

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
	
	private List<OutWxConditionalMenu> conditionalmenu;

	public OutWxConditionalMenu getMenu() {
		return menu;
	}

	public void setMenu(OutWxConditionalMenu menu) {
		this.menu = menu;
	}
	
	public List<OutWxConditionalMenu> getConditionalmenu() {
		return conditionalmenu;
	}

	public void setConditionalmenu(List<OutWxConditionalMenu> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}

	public OutWxMenu() {
		super();
	}

	@Override
	public String toString() {
		return "OutWxMenu [menu=" + menu + ", conditionalmenu=" + conditionalmenu + "]";
	}

}
