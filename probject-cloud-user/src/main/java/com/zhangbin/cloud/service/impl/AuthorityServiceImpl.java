package com.zhangbin.cloud.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.repository.AuthorityRepository;
import com.zhangbin.cloud.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public List<TbAuthority> findByAuthTypeAndIsHide(Integer authType) {
		return authorityRepository.findByAuthTypeAndIsHide(authType);
	}

	@Override
	public List<String> findByAuthIdIn(List<Long> authList) {
		if(!CollectionUtils.isEmpty(authList))
		return authorityRepository.findByAuthIdIn(authList);
		return null;
	}

}
