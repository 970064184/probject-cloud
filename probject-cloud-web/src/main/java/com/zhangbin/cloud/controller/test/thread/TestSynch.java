package com.zhangbin.cloud.controller.test.thread;

public class TestSynch {

	public static void main(String[] args) {
		Web12306 web = new Web12306(20);
		Thread t1 = new Thread(web, "黄牛1");
		Thread t2 = new Thread(web, "黄牛2");
		Thread t3 = new Thread(web, "黄牛3");
		t1.start();
		t2.start();
		t3.start();
	}

}

class Web12306 implements Runnable {

	private int num;
	private boolean flag = true;

	public Web12306() {
	}

	public Web12306(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (flag) {
//			test5();
			test3();
//			 test2();
//			 test1();
		}
	}

	/**
	 * 锁定资源不正确：线程不安全
	 */
	private void test5() {
		
		synchronized ((Integer) num) {
			// 未锁定flag
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}

	/**
	 * 锁定范围不正确：线程不安全
	 */
	private void test4() {
		// a b c
		synchronized (this) {
			// b
			if (num <= 0) {
				flag = false;
				return;
			}
		}
		// a
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
	}

	/**
	 * 同步块： 线程安全
	 */
	private void test3() {
		synchronized (this) {
			if (num <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		}
	}

	/**
	 * 同步方法：线程安全
	 */
	private synchronized void test2() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
	}

	/**
	 * 线程不安全
	 */
	private void test1() {
		if (num <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "抢到了" + num--);
		/**
		 * 黄牛2抢到了2 黄牛3抢到了2 黄牛1抢到了2 黄牛3抢到了1 黄牛2抢到了0 黄牛1抢到了1
		 */
	}

}