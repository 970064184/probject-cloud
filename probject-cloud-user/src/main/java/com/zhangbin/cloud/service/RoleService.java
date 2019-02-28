package com.zhangbin.cloud.service;

import java.util.List;

public interface RoleService {
	/**
	 * 根据角色id查找角色编码
	 * @param roleid
	 * @return
	 */
	public List<String> findByRoleIdIn(List<Long> roleid);
}
