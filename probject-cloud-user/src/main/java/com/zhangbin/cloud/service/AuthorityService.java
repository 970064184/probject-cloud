package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddAuthReq;
import com.zhangbin.cloud.controller.system.resData.AllAuthResp;
import com.zhangbin.cloud.domain.system.TbAuthority;

public interface AuthorityService {
	
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);

	List<String> findByAuthIdIn(List<Long> authList);
	/**
	 * 分页查询
	 * @param pageBean
	 * @return
	 */
	PageData<AllAuthResp> findAllAuthByPage(PageBean pageBean);
	/**
	 * 添加权限
	 * @param addAuthReq
	 * @return
	 */
	Long addAuth(AddAuthReq addAuthReq);
	/**
	 * 删除权限
	 * @param authId
	 */
	void delAuth(Long authId);
}
