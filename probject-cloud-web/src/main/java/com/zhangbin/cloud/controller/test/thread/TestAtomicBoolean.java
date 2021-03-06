package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import lombok.extern.slf4j.Slf4j;

/**代码来模拟并发请求
 * @author Administrator
 * 线程安全
 */
@Slf4j
public class TestAtomicBoolean {
	//请求总数
	public static int clientTotal = 5000;
	//同时并发执行的线程数
	public static int threadTotal = 200;
	
	public static AtomicBoolean isHappened = new AtomicBoolean(false);
	

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		//信号量
		Semaphore semaphore = new Semaphore(threadTotal);
		//计数器必锁
		CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			executorService.execute(()->{
				try {
					semaphore.acquire();
					test();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
					log.error("exception",e);
				}
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
			executorService.shutdown();
			log.info("isHappened:{}",isHappened.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/**
		 *  execue
 		*	isHappened:true
		 */
	}
	
	public static void test() {
		if(isHappened.compareAndSet(false, true)) {
			log.info("execue");
		}
	}

}
