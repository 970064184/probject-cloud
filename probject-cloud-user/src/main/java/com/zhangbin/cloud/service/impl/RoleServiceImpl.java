package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.repository.RoleRepository;
import com.zhangbin.cloud.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<String> findByRoleIdIn(List<Long> roleid) {
		if(!CollectionUtils.isEmpty(roleid))
		return roleRepository.findByRoleIdIn(roleid);
		return null;
	}

}
