package com.zhangbin.cloud.domain.sendmsg;

import java.io.Serializable;

public class MiniProgram implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appid;
	private String pagePath;
	
	
	public MiniProgram(String appid, String pagePath) {
		super();
		this.appid = appid;
		this.pagePath = pagePath;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	@Override
	public String toString() {
		return "MiniProgram [appid=" + appid + ", pagePath=" + pagePath + "]";
	}
}
