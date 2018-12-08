package com.zhangbin.cloud.controller.test.singleton;

public class TestSingleton {

	public static void main(String[] args) {
		/*Singleton4 s4 = Singleton4.getInstance();
		Singleton4 s5 = Singleton4.getInstance();
		System.out.println(s4 == s5);
		System.out.println(s4);
		System.out.println(s5);*/
		/**
		 * true
			com.zhangbin.cloud.controller.test.singleton.Singleton4@762efe5d
			com.zhangbin.cloud.controller.test.singleton.Singleton4@762efe5d
		 */
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Singleton5 s4 = Singleton5.getInstance();
				System.out.println("线程1"+Thread.currentThread().getName());
				System.out.println(s4);
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("线程2"+Thread.currentThread().getName());
				Singleton5 s5 = Singleton5.getInstance();
				System.out.println(s5);
			}
		}).start();
	}

}
