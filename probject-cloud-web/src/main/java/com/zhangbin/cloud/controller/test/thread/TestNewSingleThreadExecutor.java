package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewSingleThreadExecutor {
	
	static  int tickets = 10;
	
	public static void main(String[] args) {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		while(tickets >0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			newSingleThreadExecutor.execute(()->{
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"卖出了第"+tickets--+"张票");
				}
			});
		}
	}
}
