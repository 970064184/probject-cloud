package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(6);
		ThreadPool threadPool = new ThreadPool(20);
		newFixedThreadPool.execute(threadPool);
		newFixedThreadPool.shutdown();
	}

}
class ThreadPool implements Runnable{
	
	private int num;
//	private volatile int num;
	
	private boolean flag = true;
	
//	private Lock lock = new ReentrantLock();
	
	public ThreadPool() {
	}
	
	public ThreadPool(int num) {
		this.num = num;
	}
	
	@Override
	public  void run() { //线程体
		while(flag) {
			processFlow2();
//			processFlow();
		}
	}
	
	private void processFlow2() {
		if(!flag) {
			return;
		}
		if(num > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
//			System.out.println(Thread.currentThread().getName()+"卖出了第"+(num--)+"张票");
		}else {
			flag = false;
		}
	}
	
}