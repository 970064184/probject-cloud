package com.zhangbin.cloud.conf.redis;

public abstract class BasePrefix implements KeyPrefix {

	private int expireSeconds;

	private String prefix;

	public BasePrefix(String prefix) {
		this(0, prefix);
	}

	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {// 默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {//
		String className = getClass().getSimpleName();
		return className + ":" + prefix;
	}

}
