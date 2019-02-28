package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.repository.UserRoleRepository;
import com.zhangbin.cloud.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<Long> findByUserId(Long userid) {
		return userRoleRepository.findByUserId(userid);
	}
	
	
}
