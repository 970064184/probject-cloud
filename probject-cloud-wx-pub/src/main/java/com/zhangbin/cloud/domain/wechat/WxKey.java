package com.zhangbin.cloud.domain.wechat;

import com.zhangbin.cloud.conf.redis.BasePrefix;

public class WxKey extends BasePrefix {

	public static final int TOKEN_EXPIRE = 60*60*2;

	private WxKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static WxKey token = new WxKey(TOKEN_EXPIRE, "tk");
}
