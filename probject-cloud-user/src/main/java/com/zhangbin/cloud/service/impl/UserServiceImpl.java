package com.zhangbin.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.domain.TbUser;
import com.zhangbin.cloud.repository.UserRepository;
import com.zhangbin.cloud.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public TbUser findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
