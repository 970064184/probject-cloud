package com.zhangbin.cloud.conf.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 序列化、反序列化
 *
 * @author zb
 * @date 2018年7月26日 下午5:48:36
 */
@Configuration
public class RedisService {

	@Autowired
	JedisPool jedisPool;

	/**
	 * 获取当个对象
	 *
	 * @param prefix
	 * @param key
	 * @param cls
	 * @return
	 */
	public <T> T get(KeyPrefix prefix, String key, Class<T> cls) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真正的key
			String realKey = prefix.getPrefix() + key;
			String str = jedis.get(realKey);
			T t = stringToBean(str, cls);
			return t;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 设置对象
	 *
	 * @param prefix
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> boolean set(KeyPrefix prefix, String key, T value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String strValue = beanToString(value);
			if (StringUtils.isEmpty(strValue))
				return false;
			// 生成真正的key
			String realKey = prefix.getPrefix() + key;
			int expireSeconds = prefix.expireSeconds();
			if (expireSeconds <= 0) {
				jedis.set(realKey, strValue);
			} else {
				jedis.setex(realKey, expireSeconds, strValue);
			}
			return true;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 判断key是否存在
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> boolean exists(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真正的key
			String realKey = prefix.getPrefix() + key;
			return jedis.exists(realKey);
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 增加值（+1）
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long incr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真正的key
			String realKey = prefix.getPrefix() + key;
			return jedis.incr(realKey);
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 减少值（-1）
	 *
	 * @param prefix
	 * @param key
	 * @return
	 */
	public <T> Long decr(KeyPrefix prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 生成真正的key
			String realKey = prefix.getPrefix() + key;
			return jedis.decr(realKey);
		} finally {
			returnToPool(jedis);
		}
	}

	private <T> String beanToString(T value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == String.class) {
			return (String) value;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return "" + value;
		}
		if (clazz == long.class || clazz == Long.class) {
			return "" + value;
		}
		return JSON.toJSONString(value);
	}

	@SuppressWarnings("unchecked")
	private <T> T stringToBean(String str, Class<T> clazz) {
		if (StringUtils.isEmpty(str) || clazz == null) {
			return null;
		}
		if (clazz == String.class) {
			return (T) str;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) str;
		}
		if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}

	private void returnToPool(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

}
