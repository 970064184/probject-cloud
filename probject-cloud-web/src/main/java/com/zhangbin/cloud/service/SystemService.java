package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.controller.system.resData.TbAuthorityResData;
import com.zhangbin.cloud.domain.system.TbAuthority;

public interface SystemService {
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	List<TbAuthority> findAll();
	/**
	 * 根据类型查找菜单
	 * @param authType
	 * @return
	 */
	List<TbAuthorityResData> findByAuthTypeAndIsHide(Integer authType);

}
