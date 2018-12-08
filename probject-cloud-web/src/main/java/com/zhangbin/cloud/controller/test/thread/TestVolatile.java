package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestVolatile {

	public static void main(String[] args) {
		VolatileThread volatileThread = new VolatileThread(20);
		Thread t1 = new Thread(volatileThread, "黄牛1");
		Thread t2 = new Thread(volatileThread, "黄牛2");
		Thread t3 = new Thread(volatileThread, "黄牛3");
		Thread t4 = new Thread(volatileThread, "黄牛4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class VolatileThread implements Runnable{
	
	private int num;
//	private volatile int num;
	
	private boolean flag = true;
	
	private Lock lock = new ReentrantLock();
	
	public VolatileThread() {
	}

	public VolatileThread(int num) {
		this.num = num;
	}

	@Override
	public  void run() { //线程体
		while(flag) {
			processFlow3();
//			processFlow2();
//			processFlow();
		}
	}
	/**
	 * 线程不安全
	 */
	private void processFlow3() {
		
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
		}else {
			flag = false;
		}
	}
	/**
	 * 线程安全
	 */
	private void processFlow() {
		
		synchronized (this) {
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
			}else {
				flag = false;
			}
		}
	}
	/**
	 * 线程安全
	 */
	private void processFlow2() {
		lock.lock();
		try {
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
			}else {
				flag = false;
			}
		} finally {
			lock.unlock();
		}
	}
	
}