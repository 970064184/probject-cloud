package com.zhangbin.cloud.service;

import java.util.List;

import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AllUserResp;
import com.zhangbin.cloud.controller.system.resData.ImportUser;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.feign.resData.AddUserReq;
import com.zhangbin.cloud.feign.resData.EditUserReq;

public interface UserService {
	/**
	 * 根据用户名查找记录
	 * @param userName
	 * @return
	 */
	TbUser findByUserName(String userName);
	/**
	 * 根据用户id查找记录
	 * @param userId
	 * @return
	 */
	TbUser findByOne(Long userId);
	/**
	 * 根据用户id查找用户角色编码
	 * @param userId
	 * @return
	 */
	List<String> findRoleByUserId(Long userId);
	/**
	 * 根据用户id查找用户权限
	 * @param userId
	 * @return
	 */
	List<String> findAuthorityByUserId(Long userId);
	/**
	 * 添加用户
	 * @param addUserReq
	 * @return
	 */
	Long addUser(AddUserReq addUserReq);
	/**
	 * 修改用户
	 * @param addUserReq
	 * @return
	 */
	Long editUser(EditUserReq editUserReq);
	/**
	 * 分页查询所有用户
	 * @param pageBean
	 * @return
	 */
	PageData<AllUserResp> findAllUserByPage(PageBean pageBean);
	/**
	 * 删除用户
	 * @param userId
	 */
	void delUser(Long userId);
	/**
	 * 批量导入用户信息
	 * @param importUser
	 */
	void saveListUser(List<ImportUser> importUser);
}
