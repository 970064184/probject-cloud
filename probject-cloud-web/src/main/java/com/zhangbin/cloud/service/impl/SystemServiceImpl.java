package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.repository.system.TbAuthorityRepository;
import com.zhangbin.cloud.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private TbAuthorityRepository tbAuthorityRepository;

	@Override
	public List<TbAuthority> findAll() {
		return tbAuthorityRepository.findAll();
	}

}
