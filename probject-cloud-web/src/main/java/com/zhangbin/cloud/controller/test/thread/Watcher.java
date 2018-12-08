package com.zhangbin.cloud.controller.test.thread;

/**消费者
 * @author admin
 *
 */
public class Watcher implements Runnable {
	
	private Movie movie;
	
	public Watcher() {
	}

	public Watcher(Movie movie) {
		this.movie = movie;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			movie.watch();
		}
	}

}
