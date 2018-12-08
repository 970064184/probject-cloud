package com.zhangbin.cloud.controller.test.singleton;

public class Singleton5 {
	/**
	 * 静态内部类
	 * @author admin
	 *
	 */
	private static class InnerClass{
		private static final Singleton5 instance = new Singleton5() ;
	}
	
	private Singleton5(){
	}
	
	public static Singleton5 getInstance() {
		return InnerClass.instance;
	}
	
}
