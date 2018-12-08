package com.zhangbin.cloud.controller.test.thread;

public class TestThread1 {
	
	public static void main(String[] args) {
		Thread1 t = new Thread1();
		Thread2 t2 = new Thread2();
//		t.run();
		t.start();
		t2.start();
	} 
}
