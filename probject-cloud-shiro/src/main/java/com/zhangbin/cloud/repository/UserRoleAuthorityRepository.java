package com.zhangbin.cloud.repository;

import java.util.List;

public interface UserRoleAuthorityRepository {
	/**
	 * 根据用户id查找用户角色编码
	 */
	List<String> findRoleByUserId(Long userId);
	/**
	 * 根据用户id查找用户权限
	 * @param userId
	 * @return
	 */
	List<String> findAuthorityByUserId(Long userId);
}
