package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.repository.TbRolesMenuRepository;
import com.zhangbin.cloud.service.TbRolesMenuService;

@Service
public class TbRolesMenuServiceImpl implements TbRolesMenuService {
	
	@Autowired
	private TbRolesMenuRepository tbRolesMenuRepository;

	@Override
	public List<Long> findByRoleIdIn(List<Long> roleId) {
		if(!CollectionUtils.isEmpty(roleId)) {
			return tbRolesMenuRepository.findByRoleIdIn(roleId);
		}
		return null;
	}

}
