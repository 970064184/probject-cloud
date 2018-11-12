package com.zhangbin.cloud.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import javax.management.InstanceAlreadyExistsException;

import org.junit.Test;

import com.netflix.discovery.converters.EurekaJacksonCodec.InstanceInfoDeserializer;

import ch.qos.logback.core.net.SyslogOutputStream;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class TestRedis {
	
	Jedis jedis = new Jedis("192.168.230.129", 6380);
	
	@Test
	public void test() {
		System.out.println(jedis.ping());
		jedis.set("k8", "v8");
		System.out.println(jedis.get("k8"));
		Set<String> keys = jedis.keys("*");
		System.out.println(keys.size());
	}
	
	@Test
	public void test1() throws Exception {
		/*jedis.set("k9", "9");
		System.out.println(jedis.type("k9"));
		System.out.println(jedis.incr("k9"));
		System.out.println(jedis.get("k9"));
		System.out.println(jedis.incrBy("k9", 3));
		System.out.println(jedis.get("k9"));*/
		Transaction multi = jedis.multi();
		Thread.sleep(7000);
		multi.decrBy("k9", 10);
		multi.exec();
	}
	
	@Test
	public void test2() throws Exception {
		int balance = 0;
		int debt = 0;
		int amtToSubtract = 10;
//		jedis.watch("balance");
		balance = Integer.parseInt(jedis.get("balance"));
		Thread.sleep(7000);
		if(balance < amtToSubtract) {
//			jedis.unwatch();
			System.out.println("modify");
		}else {
			System.out.println("--------transaction");
			Transaction multi = jedis.multi();
			multi.decrBy("balance", amtToSubtract);
			multi.incrBy("debt", amtToSubtract);
			multi.exec();
			balance = Integer.parseInt(jedis.get("balance"));
			debt = Integer.parseInt(jedis.get("debt"));
			System.out.println("剩余额度："+balance);
			System.out.println("花费金额："+debt);
		}
	}
	
	@Test
	public void test3()  {
		Jedis jedis_S = new Jedis("192.168.230.129", 6379);
		jedis_S.slaveof("192.168.230.129", 6380);
		jedis.set("java4", "java ee4");
		System.out.println(jedis_S.get("java4"));
	}
	
	@Test
	public void test4() {
		JedisPool jedisPool = new JedisPool("192.168.230.129", 6380);
		Jedis resource = jedisPool.getResource();
		resource.set("aa", "bb");
	}
	@Test
	public void test5() throws Exception  {
		LocalDateTime currentTimeMillis = LocalDateTime.now();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 50000; j++) {
						Jedis jedis1 = new Jedis("192.168.230.129", 6380);
						jedis1.set("nopool78", "nopool");
					}
				}
			}).start();
		}
		LocalDateTime endTimeMillis = LocalDateTime.now();
		System.out.println(Duration.between(currentTimeMillis, endTimeMillis).toMillis());
		Thread.sleep(200);
	}
	
	@Test
	public void test6() throws Exception {
		JedisPool jedisPool = new JedisPool("192.168.230.129", 6380);
		LocalDateTime currentTimeMillis = LocalDateTime.now();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 50000; j++) {
						Jedis resource = jedisPool.getResource();
						resource.set("pool78", "bb");
					}
				}
			}).start();
		}
		LocalDateTime endTimeMillis = LocalDateTime.now();
		System.out.println(Duration.between(currentTimeMillis, endTimeMillis).toMillis());
		Thread.sleep(200);
	}
	@Test
	public void test7() throws Exception  {
		LocalDateTime currentTimeMillis = LocalDateTime.now();
		for (int i = 0; i < 100; i++) {
			Jedis jedis1 = new Jedis("192.168.230.129", 6380);
			jedis1.set("nopool2", "nopool");
		}
		LocalDateTime endTimeMillis = LocalDateTime.now();
		System.out.println(Duration.between(currentTimeMillis, endTimeMillis).toMillis());//170
	}
	
	@Test
	public void test8() throws Exception {
		JedisPool jedisPool = new JedisPool("192.168.230.129", 6380);
		LocalDateTime currentTimeMillis = LocalDateTime.now();
		for (int i = 0; i < 100; i++) {
			Jedis resource = jedisPool.getResource();
			resource.set("pool2", "bb");
			resource.close();
		}
		LocalDateTime endTimeMillis = LocalDateTime.now();
		System.out.println(Duration.between(currentTimeMillis, endTimeMillis).toMillis());//59
	}
}
