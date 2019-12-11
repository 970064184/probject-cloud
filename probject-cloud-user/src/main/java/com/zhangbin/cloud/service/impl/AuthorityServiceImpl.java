package com.zhangbin.cloud.service.impl;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageBeanUtils;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AddAuthReq;
import com.zhangbin.cloud.controller.system.resData.AllAuthResp;
import com.zhangbin.cloud.controller.system.resData.EditAuthReq;
import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.repository.AuthorityRepository;
import com.zhangbin.cloud.service.AuthorityService;
import com.zhangbin.cloud.utils.BeanUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.*;

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
		if(!CollectionUtils.isEmpty(authList)){
			return authorityRepository.findAuthUrlByAuthIdIn(authList);
		}
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
		if(findByAuthNameAndIsHide !=null){
			throw new BusinessException(CodeEnum.USER_AUTHNAME_IN_ISEXIST);
		}
		TbAuthority authority = new TbAuthority();
		BeanUtil.copyProperties(addAuthReq, authority);
		authority.setPid(addAuthReq.getPid());
		authority.setCreated(new Date());
		Long authId = authorityRepository.save(authority).getAuthId();
 		return authId;
	}

	@Override
	public void delAuth(Long authId) {
		authorityRepository.deleteById(authId);
	}

	@Override
	public List<TbAuthority> findByAuthIdIn(List<Long> authList) {
		return authorityRepository.findByAuthIdIn(authList);
	}

	@Override
	public List<TbAuthority> findAllByIsHide() {
		return authorityRepository.findAllByIsHide();
	}

	@Override
	public Long editAuth(EditAuthReq editAuthReq) {
		TbAuthority one = authorityRepository.findById(editAuthReq.getAuthId()).get();
		if(one == null){
			throw new BusinessException(CodeEnum.USER_AUTHID_CANNOT_EXIST);
		}
		/**
		 * 查重名
		 */
		TbAuthority findByAuthNameAndIsHide = authorityRepository.findByAuthIdNotAndAuthNameAndIsHide(editAuthReq.getAuthId(),editAuthReq.getAuthName(),0);
		if(findByAuthNameAndIsHide !=null){
			throw new BusinessException(CodeEnum.USER_AUTHNAME_IN_ISEXIST);
		}
		BeanUtil.copyPropertiesIgnoreNull(editAuthReq,one);
		one.setUpdated(new Date());
		Long authId = authorityRepository.save(one).getAuthId();
		return authId;
	}

	@Override
	public List<AllAuthResp> findAllAuth(PageBean pageBean) {
		List<TbAuthority> list = authorityRepository.findAll();
		List<AllAuthResp> allUserResp = new ArrayList<>();
		allUserResp = BeanUtil.createBean(list, AllAuthResp.class);
		return allUserResp;
	}

}
