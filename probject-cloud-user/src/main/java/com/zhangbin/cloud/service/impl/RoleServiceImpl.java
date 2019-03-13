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
import com.zhangbin.cloud.controller.system.resData.AddRoleReq;
import com.zhangbin.cloud.controller.system.resData.AllRoleResp;
import com.zhangbin.cloud.domain.system.TbRole;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.repository.RoleRepository;
import com.zhangbin.cloud.service.RoleService;
import com.zhangbin.cloud.utils.BeanUtil;

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

	@Override
	public PageData<AllRoleResp> findAllRoleByPage(PageBean pageBean) {
		Map<String, Direction> map = new HashMap<>();
		map.put("created", Direction.DESC);
		PageRequest pageRequest = PageBeanUtils.pageRequest(pageBean.getPage(), pageBean.getLimit(), map);
		Page<TbRole> findAll = roleRepository.findAll(pageRequest);
		List<TbRole> list = findAll.getContent();
		List<AllRoleResp> allUserResp = new ArrayList<>();
		allUserResp = BeanUtil.createBean(list, AllRoleResp.class);
		PageData<AllRoleResp> pageData = new PageData<>(findAll.getTotalElements(),allUserResp);
		return pageData;
	}

	@Override
	public Long addRole(AddRoleReq addRoleReq) {
		TbRole findByRoleName = roleRepository.findByRoleName(addRoleReq.getRoleName());
		if(findByRoleName !=null)
			throw new BusinessException(CodeEnum.USER_ROLENAME_IN_ISEXIST);
		TbRole target = new TbRole();
		BeanUtil.copyProperties(addRoleReq, target);
		target.setCreated(new Date());
		target.setRoleCode(String.valueOf(System.currentTimeMillis()));
		Long roleId = roleRepository.save(target).getRoleId();
		return roleId;
	}

	@Override
	public void delRole(Long roleId) {
		roleRepository.delete(roleId);
	}

}
