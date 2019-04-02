package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;

/**微信查询接口返回参数
 * @author admin
 *
 */
public class WxMenuMatchRule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String group_id;
	
	private int sex;
	
	private String country;
	
	private String province;
	
	private String city;
	
	private int client_platform_type;
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public int getClient_platform_type() {
		return client_platform_type;
	}
	public void setClient_platform_type(int client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
	@Override
	public String toString() {
		return "WxMenuMatchRule [group_id=" + group_id + ", sex=" + sex + ", country=" + country + ", province="
				+ province + ", city=" + city + ", client_platform_type=" + client_platform_type + "]";
	}
}
