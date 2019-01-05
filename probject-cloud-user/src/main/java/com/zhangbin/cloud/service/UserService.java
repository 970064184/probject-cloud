package com.zhangbin.cloud.service;

import com.zhangbin.cloud.domain.TbUser;

public interface UserService {
	/**
	 * 根据用户名查找记录
	 * @param userName
	 * @return
	 */
	TbUser findByUserName(String userName);
}
