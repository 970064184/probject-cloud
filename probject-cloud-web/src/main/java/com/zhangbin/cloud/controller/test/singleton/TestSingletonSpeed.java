package com.zhangbin.cloud.controller.test.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下两种创建单例模式的效率
 * @author admin
 *
 */
public class TestSingletonSpeed {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		int count = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
//						Object o = Singleton4.getInstance();//懒汉式：总耗时：1105
						Object o = Singleton5.getInstance();//静态内部类：总耗时：15
					}
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await();//main线程阻塞，直到计数器变为0，才会继续往下执行
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end - start));
		
	}

}
