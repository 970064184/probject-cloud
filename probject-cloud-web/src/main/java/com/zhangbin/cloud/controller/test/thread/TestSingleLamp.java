package com.zhangbin.cloud.controller.test.thread;

/**
 * 测试死锁的解决方法之 信号灯法
 * @author admin
 *
 */
public class TestSingleLamp {

	public static void main(String[] args) {
		//多线程对同一个资源的访问
		Movie m = new Movie();
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(w);
		System.out.println(t1.getName());
		t1.start();
		t2.start();
		
	}

}
