package com.zhangbin.cloud.controller.test.thread;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestAtomicIntegerFieldUpdater {
	
	private static AtomicIntegerFieldUpdater<TestAtomicIntegerFieldUpdater> updater = AtomicIntegerFieldUpdater.newUpdater(TestAtomicIntegerFieldUpdater.class, "count");
	
	@Getter
	public volatile int count = 100;
	
	public static void main(String[] args) {
		TestAtomicIntegerFieldUpdater t = new TestAtomicIntegerFieldUpdater();
		
		if(updater.compareAndSet(t, 100, 120)) {
			log.info("update success 1,{}",t.getCount());
		}
		
		if(updater.compareAndSet(t, 100, 120)) {
			log.info("update success 2,{}",t.getCount());
		}else {
			log.info("update failed");
		}
		/**
		 * update success 1,120
		 * update failed
		 */
	}

}
