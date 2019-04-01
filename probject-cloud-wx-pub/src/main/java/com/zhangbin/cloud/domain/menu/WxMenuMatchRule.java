package com.zhangbin.cloud.domain.menu;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**微信查询接口返回参数
 * @author admin
 *
 */
public class WxMenuMatchRule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JSONField(name = "group_id")
	private String groupId;
	
	private int sex;
	
	private String country;
	
	private String province;
	
	private String city;
	
	@JSONField(name = "client_platform_type")
	private int clientPlatformType;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
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
	public int getClientPlatformType() {
		return clientPlatformType;
	}
	public void setClientPlatformType(int clientPlatformType) {
		this.clientPlatformType = clientPlatformType;
	}
	@Override
	public String toString() {
//		return "WxMenuMatchRule [groupId=" + groupId + ", sex=" + sex + ", country=" + country + ", province="
//				+ province + ", city=" + city + ", clientPlatformType=" + clientPlatformType + "]";
		return JSONObject.toJSONString(this);
	}
	
	public String toJson() {
		return JSONObject.toJSONString(this);
	}
}
