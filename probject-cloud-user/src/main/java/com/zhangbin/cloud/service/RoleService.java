package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddRoleReq;
import com.zhangbin.cloud.controller.system.resData.AllRoleResp;
import com.zhangbin.cloud.controller.system.resData.ConfigAuthReq;
import com.zhangbin.cloud.controller.system.resData.TbAuthorityResp;

public interface RoleService {
	/**
	 * 根据角色id查找角色编码
	 * @param roleid
	 * @return
	 */
	public List<String> findByRoleIdIn(List<Long> roleid);
	/**
	 * 分页查询
	 * @param pageBean
	 * @return
	 */
	public PageData<AllRoleResp> findAllRoleByPage(PageBean pageBean);
	
	/**
	 * 添加角色
	 * @param addRoleReq
	 * @return
	 */
	public Long addRole(AddRoleReq addRoleReq);
	/**
	 * 删除角色
	 * @param roleId
	 */
	public void delRole(Long roleId);
	/**
	 * 为角色分配权限
	 * @param configAuthReq
	 */
	public void configAuth(ConfigAuthReq configAuthReq);
	/**
	 * 查询角色对应的权限
	 * @param roleId
	 * @return
	 */
	public List<TbAuthorityResp> findByRoleId(Long roleId);
}
