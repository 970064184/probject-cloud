package com.zhangbin.cloud.controller.test.thread;

/**
 * @author admin
 * 使用Runnable创建线程
 * 1、类实现Runnable接口 + 重写run() --》真实角色类
 * 2、启动多线程，使用静态代理
 * 1)创建真实角色
 * 2）创建代理角色+真实角色引用
 * 3）调用start()启动线程
 *
 */
public class TestThread3 {

	public static void main(String[] args) {
		Thread3 t3 = new Thread3();
		Thread t = new Thread(t3);
		t.start();
	}

}
