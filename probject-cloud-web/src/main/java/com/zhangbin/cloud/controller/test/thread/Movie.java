package com.zhangbin.cloud.controller.test.thread;

/**共同的资源
 * @author admin
 *死锁的解决办法：
 *生产者消费者模式--》信号灯法
 *
 */
public class Movie {
	
	private String p;
	/**
	 *信号灯
	 *flag=true 生成生产，消费者等待，生产完成后通知消费
	 *flag=flase 消费者消费，生产者等待，消费完成后通知生成
	 *wait()：等待，释放锁，sleep ：不释放锁
	 *notify()/notifyAll()：唤醒
	 *与synchronized一起使用
	 */
	private boolean flag = true;
	
	
	//播放
	public synchronized void play(String p) {
		if(!flag) {//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//生成完成，
		System.out.println("生产了"+p);
		this.p = p;
		//通知消费者
		this.notify();
		//停止生产
		this.flag = false;
	}
	//查看
	public synchronized void watch() {
		if(flag) {//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//消费完成
		System.out.println("消费了"+p);
		//通知生产
		this.notifyAll();
		//消费停止
		this.flag = true;
	}
}
