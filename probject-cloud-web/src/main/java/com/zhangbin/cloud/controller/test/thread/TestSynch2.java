package com.zhangbin.cloud.controller.test.thread;

/**
 * 过多的同步容易造成死锁
 * 
 * @author admin
 *
 */
public class TestSynch2 {

	public static void main(String[] args) {
		Object goods = new Object();
		Object money = new Object();
		Test t1 = new Test(goods,money);
		Test2 t2 = new Test2(goods,money);
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		th1.start();
		th2.start();
	}

}

class Test implements Runnable {

	Object goods;
	Object money;

	public Test() {
	}

	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while (true) {
			test();
		}
//		test();
	}

	private void test() {
		synchronized (goods) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (money) {

			}
		}
		System.out.println("一手给钱");
	}

}
class Test2 implements Runnable {
	
	Object goods;
	Object money;
	
	public Test2() {
	}
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	
	@Override
	public void run() {
		while (true) {
			test2();
		}
//		test2();
	}
	
	private void test2() {
		synchronized (money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (goods) {
				
			}
		}
		System.out.println("一手给货");
	}
	
}