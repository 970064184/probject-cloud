package com.zhangbin.cloud.service;

import java.util.List;

public interface TbRolesMenuService {
	
	/**
	 * 根据用户角色id查找权限id
	 * @param roleId
	 * @return
	 */
	public List<Long> findByRoleIdIn(List<Long> roleId);
}
