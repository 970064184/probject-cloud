package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.domain.system.TbAuthority;

public interface AuthorityService {
	
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);

	List<String> findByAuthIdIn(List<Long> authList);
}
