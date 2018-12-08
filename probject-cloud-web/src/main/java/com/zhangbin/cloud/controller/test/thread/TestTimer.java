package com.zhangbin.cloud.controller.test.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("test so easy");
			}
		}, new Date(System.currentTimeMillis()+1000), 200);
		
	}

}
