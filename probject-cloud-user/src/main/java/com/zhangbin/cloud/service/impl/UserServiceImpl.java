package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageBeanUtils;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AllUserResp;
import com.zhangbin.cloud.controller.system.resData.ImportUser;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.feign.resData.AddUserReq;
import com.zhangbin.cloud.feign.resData.EditUserReq;
import com.zhangbin.cloud.repository.UserRepository;
import com.zhangbin.cloud.service.AuthorityService;
import com.zhangbin.cloud.service.RoleService;
import com.zhangbin.cloud.service.TbRolesMenuService;
import com.zhangbin.cloud.service.UserRoleService;
import com.zhangbin.cloud.service.UserService;
import com.zhangbin.cloud.utils.BeanUtil;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private TbRolesMenuService tbRolesMenuService;
	@Autowired
	private AuthorityService authorityService;

	@Override
	public TbUser findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public TbUser findByOne(Long userId) {
		return userRepository.findOne(userId);
	}
	
	
	@Override
	public List<String> findRoleByUserId(Long userId) {
		// 获得该用户角色
		List<String> roleCodeList = new ArrayList<>();
		List<Long> roleId = userRoleService.findByUserId(userId);
		if (!CollectionUtils.isEmpty(roleId)) {
			roleCodeList = roleService.findByRoleIdIn(roleId);
		}
		return roleCodeList;
	}

	@Override
	public List<String> findAuthorityByUserId(Long userId) {
		// 每个角色拥有默认的权限
		List<String> authUrlList = new ArrayList<>();
		List<Long> roleId = userRoleService.findByUserId(userId);
		List<Long> authList = tbRolesMenuService.findByRoleIdIn(roleId);
		if (!CollectionUtils.isEmpty(authList)) {
			authUrlList = authorityService.findByAuthIdIn(authList);
		}
		return authUrlList;
	}

	@Override
	@Transactional
	public Long addUser(AddUserReq addUserReq) {
		TbUser user = userRepository.findByUserName(addUserReq.getUserName());
		if(user !=null) {
			throw new BusinessException(CodeEnum.USER_USERNAME_ISEXIST);
		}
		TbUser findByUserPhone = userRepository.findByUserPhone(addUserReq.getUserPhone());
		if(findByUserPhone !=null) {
			throw new BusinessException(CodeEnum.USER_USERPHONE_ISEXIST);
		}
		TbUser tbUser = new TbUser();
		BeanUtils.copyProperties(addUserReq, tbUser);
		tbUser.setCreated(new Date());
		tbUser.setRegistType(1);//注册类型(1=系统录入，2=注册)
		return userRepository.save(tbUser).getUserId();
	}

	@Override
	public Long editUser(EditUserReq editUserReq) {
		TbUser findOne = userRepository.findOne(editUserReq.getUserId());
		if(findOne ==null) {
			throw new BusinessException(CodeEnum.SYSTEM_USERNAME_ISNOTEXIST);
		}
		TbUser user = userRepository.findRepeatByUserName(editUserReq.getUserName(),editUserReq.getUserId());
		if(user !=null) {
			throw new BusinessException(CodeEnum.USER_USERNAME_ISEXIST);
		}
		TbUser findByUserPhone = userRepository.findRepeatByUserPhone(editUserReq.getUserPhone(),editUserReq.getUserId());
		if(findByUserPhone !=null) {
			throw new BusinessException(CodeEnum.USER_USERPHONE_ISEXIST);
		}
		BeanUtils.copyProperties(editUserReq, findOne);
		Long userId = userRepository.save(findOne).getUserId();
		return userId;
	}

	@Override
	public PageData<AllUserResp> findAllUserByPage(PageBean pageBean) {
		Map<String, Direction> map = new HashMap<>();
		map.put("created", Direction.DESC);
		PageRequest pageRequest = PageBeanUtils.pageRequest(pageBean.getPage(), pageBean.getLimit(), map);
		Page<TbUser> findAll = userRepository.findAll(pageRequest);
		List<TbUser> list = findAll.getContent();
		List<AllUserResp> allUserResp = new ArrayList<>();
		allUserResp = BeanUtil.createBean(list, AllUserResp.class);
		PageData<AllUserResp> pageData = new PageData<>(findAll.getTotalElements(),allUserResp);
		return pageData;
	}

	@Override
	@Transactional
	public void delUser(Long userId) {
		userRepository.delete(userId);
	}

	@Override
	@Transactional
	public void saveListUser(List<ImportUser> importUser) {
		List<TbUser> tbUserList = new ArrayList<>();
		/**
		 * 查必要信息是否已填
		 * 查用户和手机号码重名
		 */
		
		userRepository.save(tbUserList);
	}
}
