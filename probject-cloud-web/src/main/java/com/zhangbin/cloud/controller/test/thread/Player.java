package com.zhangbin.cloud.controller.test.thread;

/**生产者
 * @author admin
 *
 */
public class Player implements Runnable {
	private Movie movie;
	
	public Player() {
	}

	public Player(Movie movie) {
		super();
		this.movie = movie;
	}


	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(i % 2 == 0) {
				movie.play("左青龙");
			}else {
				movie.play("哟白虎");
			}
		}
	}

}
