package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.domain.system.TbMenu;
import com.zhangbin.cloud.repository.system.TbMenuRepository;
import com.zhangbin.cloud.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private TbMenuRepository tbMenuRepository;

	@Override
	public List<TbMenu> findAll() {
		return tbMenuRepository.findAll();
	}

}
