package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageBeanUtils;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddAuthReq;
import com.zhangbin.cloud.controller.system.resData.AllAuthResp;
import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.repository.AuthorityRepository;
import com.zhangbin.cloud.service.AuthorityService;
import com.zhangbin.cloud.utils.BeanUtil;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public List<TbAuthority> findByAuthTypeAndIsHide(Integer authType) {
		return authorityRepository.findByAuthTypeAndIsHide(authType);
	}

	@Override
	public List<String> findAuthUrlByAuthIdIn(List<Long> authList) {
		if(!CollectionUtils.isEmpty(authList))
		return authorityRepository.findAuthUrlByAuthIdIn(authList);
		return null;
	}

	@Override
	public PageData<AllAuthResp> findAllAuthByPage(PageBean pageBean) {
		Map<String, Direction> map = new HashMap<>();
		map.put("created", Direction.DESC);
		PageRequest pageRequest = PageBeanUtils.pageRequest(pageBean.getPage(), pageBean.getLimit(), map);
		Page<TbAuthority> findAll = authorityRepository.findAll(pageRequest);
		List<TbAuthority> list = findAll.getContent();
		List<AllAuthResp> allUserResp = new ArrayList<>();
		allUserResp = BeanUtil.createBean(list, AllAuthResp.class);
		PageData<AllAuthResp> pageData = new PageData<>(findAll.getTotalElements(),allUserResp);
		return pageData;
	}

	@Override
	public Long addAuth(AddAuthReq addAuthReq) {
		/**
		 * 查重名
		 */
		TbAuthority findByAuthNameAndIsHide = authorityRepository.findByAuthNameAndIsHide(addAuthReq.getAuthName(),0);
		if(findByAuthNameAndIsHide !=null)
			throw new BusinessException(CodeEnum.USER_AUTHNAME_IN_ISEXIST);
		TbAuthority authority = new TbAuthority();
		BeanUtil.copyProperties(addAuthReq, authority);
		authority.setCreated(new Date());
		Long authId = authorityRepository.save(authority).getAuthId();
 		return authId;
	}

	@Override
	public void delAuth(Long authId) {
		authorityRepository.delete(authId);
	}

	@Override
	public List<TbAuthority> findByAuthIdIn(List<Long> authList) {
		return authorityRepository.findByAuthIdIn(authList);
	}

	@Override
	public List<TbAuthority> findAllByIsHide() {
		return authorityRepository.findAllByIsHide();
	}

}
