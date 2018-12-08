package com.zhangbin.cloud.controller.test.proxy;
/**
 * 代理角色
 * @author admin
 *
 */
public	class WeddingCompany implements Marry{
		
	private Marry you;
	
	public WeddingCompany() {
		super();
	}

	public WeddingCompany(Marry you) {
		this.you = you;
	}

	private void before() {
		System.out.println("布置会场");
	}
	
	private void after() {
		System.out.println("收拾会场");
	}
	
	@Override
	public void marry() {
		before();
		you.marry();
		after();
	}
}