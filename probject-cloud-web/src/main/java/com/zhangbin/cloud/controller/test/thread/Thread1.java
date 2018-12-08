package com.zhangbin.cloud.controller.test.thread;

/**
 * @author admin
 *继承Thread ，并重写run方法
 *启动：调用strat()方法
 */
public class Thread1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"启动了，第"+i+"次");
		}
	}
}
 class Thread2 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"启动了，第"+i+"次");
		}
	}
}
