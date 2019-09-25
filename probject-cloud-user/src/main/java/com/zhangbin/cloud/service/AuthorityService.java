package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddAuthReq;
import com.zhangbin.cloud.controller.system.resData.AllAuthResp;
import com.zhangbin.cloud.controller.system.resData.EditAuthReq;
import com.zhangbin.cloud.controller.system.resData.TbAuthorityResp;
import com.zhangbin.cloud.domain.system.TbAuthority;

public interface AuthorityService {
	
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);
	/**
	 * 根据一批权限ID查找记录的权限url
	 * @param authList
	 * @return
	 */
	List<String> findAuthUrlByAuthIdIn(List<Long> authList);
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
	/**
	 * 根据一批权限ID查找记录的权限记录
	 * @param authList
	 * @return
	 */
	List<TbAuthority> findByAuthIdIn(List<Long> authList);
	/**
	 * 查询所有有效记录
	 * @return
	 */
	List<TbAuthority> findAllByIsHide();

	/**
	 * 编辑权限
	 * @param editAuthReq
	 * @return
	 */
    Long editAuth(EditAuthReq editAuthReq);

	/**
	 * 查询所有权限
	 * @param pageBean
	 * @return
	 */
	List<AllAuthResp> findAllAuth(PageBean pageBean);
}
