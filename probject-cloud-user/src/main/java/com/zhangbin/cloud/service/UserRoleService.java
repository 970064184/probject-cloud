package com.zhangbin.cloud.service;

import java.util.List;

public interface UserRoleService {
	
	/**
	 * 根据用户id查询用户角色id
	 * @param userid
	 * @return
	 */
	public List<Long> findByUserId(Long userid);

}
