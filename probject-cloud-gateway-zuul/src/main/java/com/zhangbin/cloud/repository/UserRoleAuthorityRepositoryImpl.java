package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.feign.UserFeignClient;

@Service
public class UserRoleAuthorityRepositoryImpl implements UserRoleAuthorityRepository {
	
	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public List<String> findRoleByUserId(Long userId) {
		return userFeignClient.findRoleByUserId(userId).getData();
	}

	@Override
	public List<String> findAuthorityByUserId(Long userId) {
		return userFeignClient.findAuthorityByUserId(userId).getData();
	}

}
