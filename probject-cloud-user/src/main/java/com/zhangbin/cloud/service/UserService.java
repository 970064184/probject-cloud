package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.domain.system.TbUser;

public interface UserService {
	/**
	 * 根据用户名查找记录
	 * @param userName
	 * @return
	 */
	TbUser findByUserName(String userName);
	/**
	 * 根据用户id查找记录
	 * @param userId
	 * @return
	 */
	TbUser findByOne(Long userId);
	
	List<String> findRoleByUserId(Long userId);
	
	List<String> findAuthorityByUserId(Long userId);
}
