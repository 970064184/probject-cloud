package com.zhangbin.cloud.conf.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 初始化连接 ，将JedisPool注入到容器里
 *
 * @author zb
 * @date 2018年7月27日 下午4:24:38
 */
@Configuration
public class RedisPoolFactory {

	@Bean
	public JedisPool JedisPoolFactory(RedisProperties redisProperties) {
		System.out.println("最大：" + redisProperties.getPool().getMaxIdle() + ";最大总："
				+ redisProperties.getPool().getMaxActive() + ";等待时间：" + redisProperties.getPool().getMaxWait() + ";主机名："
				+ redisProperties.getHost() + ";端口号：" + redisProperties.getPort());
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
		poolConfig.setMaxTotal(redisProperties.getPool().getMaxActive());
		poolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait() * 1000);
		JedisPool jp = new JedisPool(poolConfig, redisProperties.getHost(), redisProperties.getPort(),
				redisProperties.getTimeout() * 1000, redisProperties.getPassword(), 0);
		return jp;
	}
}
