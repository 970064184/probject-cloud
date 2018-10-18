package com.zhangbin.cloud.controller;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the tb_menu database table.
 * 
 */
public class TbMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String logo;

	private String name;

	private String url;

	public TbMenu() {
		super();
	}

	public TbMenu(String id, String logo, String name, String url) {
		super();
		this.id = id;
		this.logo = logo;
		this.name = name;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}