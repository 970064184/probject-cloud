package com.zhangbin.cloud.service;

import java.util.List;

public interface TbRolesMenuService {
	
	/**
	 * 根据一批用户角色id查找权限id
	 * @param roleId
	 * @return
	 */
	public List<Long> findByRoleIdIn(List<Long> roleId);
	/**
	 * 保存角色和权限的关系
	 * @param roleId
	 * @param authId
	 */
	public void saveRolesMenu(Long roleId, List<Long> authId);
	
	/**
	 * 根据用户角色id查询权限id
	 * @param roleId
	 * @return
	 */
	public List<Long> findByRole(Long roleId);
}
