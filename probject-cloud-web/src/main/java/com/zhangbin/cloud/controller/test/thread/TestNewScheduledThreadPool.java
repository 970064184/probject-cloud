package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestNewScheduledThreadPool {
	
	public static void main(String[] args) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
		/*newScheduledThreadPool.schedule(()->{
			System.out.println("delay 3 seconds");
		}, 3, TimeUnit.SECONDS);*/
		
		newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			  
			@Override
			public void run() {
			System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
			}, 1, 3, TimeUnit.SECONDS);
	}
}
