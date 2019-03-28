package com.zhangbin.cloud.conf.redis;

public interface KeyPrefix {

	int expireSeconds();

	String getPrefix();
}
