package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.repository.UserRepository;
import com.zhangbin.cloud.service.AuthorityService;
import com.zhangbin.cloud.service.RoleService;
import com.zhangbin.cloud.service.TbRolesMenuService;
import com.zhangbin.cloud.service.UserRoleService;
import com.zhangbin.cloud.service.UserService;
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
}
