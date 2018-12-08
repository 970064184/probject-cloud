package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SellTickets {

	static int tickets =10;
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(6);
		while(tickets >0) {
			/*service.execute(()->{
				if(tickets >0) {
					System.out.println(Thread.currentThread().getName()+"卖出了第"+(tickets--)+"张票");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});*/
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					if(tickets >0) {
						System.out.println(Thread.currentThread().getName()+"卖出了第"+(tickets--)+"张票");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		//关闭线程池
		service.shutdown();
	}

}
