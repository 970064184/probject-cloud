package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.domain.system.TbAuthority;

public interface SystemService {
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	List<TbAuthority> findAll();

}
