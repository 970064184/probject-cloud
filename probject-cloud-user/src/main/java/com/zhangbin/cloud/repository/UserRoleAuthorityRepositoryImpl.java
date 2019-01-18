package com.zhangbin.cloud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserRoleAuthorityRepositoryImpl implements UserRoleAuthorityRepository {

	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private TbRolesMenuRepository tbRolesMenuRepository;
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public List<String> findRoleByUserId(Long userId) {
		// 获得该用户角色
		List<String> roleCodeList = new ArrayList<>();
		List<Long> roleId = userRoleRepository.findByUserId(userId);
		if (!CollectionUtils.isEmpty(roleId)) {
			roleCodeList = roleRepository.findByRoleIdIn(roleId);
		}
		return roleCodeList;
	}

	@Override
	public List<String> findAuthorityByUserId(Long userId) {
		// 每个角色拥有默认的权限
		List<String> authUrlList = new ArrayList<>();
		List<Long> roleId = userRoleRepository.findByUserId(userId);
		List<Long> authList = tbRolesMenuRepository.findByRoleIdIn(roleId);
		if (!CollectionUtils.isEmpty(authList)) {
			authUrlList = authorityRepository.findByAuthIdIn(authList);
		}
		return authUrlList;
	}

}
