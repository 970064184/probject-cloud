package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
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
import com.zhangbin.cloud.controller.system.resData.ConfigAuthReq;
import com.zhangbin.cloud.controller.system.resData.TbAuthorityResp;
import com.zhangbin.cloud.domain.system.TbAuthority;
import com.zhangbin.cloud.domain.system.TbRole;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.repository.RoleRepository;
import com.zhangbin.cloud.service.AuthorityService;
import com.zhangbin.cloud.service.RoleService;
import com.zhangbin.cloud.service.TbRolesMenuService;
import com.zhangbin.cloud.utils.BeanUtil;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private TbRolesMenuService tbRolesMenuService;

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

	@Override
	public void configAuth(ConfigAuthReq configAuthReq) {
		TbRole findOne = roleRepository.findOne(configAuthReq.getRoleId());
		if(findOne == null)
			throw new BusinessException(CodeEnum.USER_ROLEID_CANNOT_EXIST);
		List<TbAuthority> findByAuthIdIn = authorityService.findByAuthIdIn(configAuthReq.getAuthId());
		if(findByAuthIdIn.size() != configAuthReq.getAuthId().size())
			throw new BusinessException(CodeEnum.USER_AUTHID_CANNOT_EXIST);
		tbRolesMenuService.saveRolesMenu(configAuthReq.getRoleId(),configAuthReq.getAuthId());
	}

	@Override
	public List<TbAuthorityResp> findByRoleId(Long roleId) {
		TbRole findOne = roleRepository.findOne(roleId);
		if(findOne == null)
			throw new BusinessException(CodeEnum.USER_ROLEID_CANNOT_EXIST);
		List<Long> authIdList = tbRolesMenuService.findByRole(roleId);
		
		List<TbAuthority> tbAuthorityList = authorityService.findAllByIsHide();
		List<TbAuthorityResp> list= new ArrayList<>();
		if(!CollectionUtils.isEmpty(tbAuthorityList)) {
			for (TbAuthority t : tbAuthorityList) {
				if (t.getPId() == -1) {
					TbAuthorityResp r = new TbAuthorityResp();
					r.setCheck(authIdList.contains(t.getAuthId()));
					BeanUtils.copyProperties(t, r);
					list.add(r);
				}
			}
			subFunction(tbAuthorityList, list,authIdList);
			
		}
		
		
		return list;
	}
	
	/**
	 * 子菜单递归生成函数
	 * @param tbAuthorityList
	 * @param list
	 */
	private void subFunction(List<TbAuthority> tbAuthorityList, List<TbAuthorityResp> list,List<Long> authIdList) {
		if(!CollectionUtils.isEmpty(list)) {
			tbAuthorityList.removeAll(list);
			if(!CollectionUtils.isEmpty(tbAuthorityList)) {
				for (TbAuthorityResp tbAuthorityResData : list) {
					List<TbAuthorityResp> children = new ArrayList<>();
					for (TbAuthority tbAuthority : tbAuthorityList) {
						if(tbAuthorityResData.getAuthId().equals(tbAuthority.getPId())) {
							TbAuthorityResp r = new TbAuthorityResp();
							for (Long authId : authIdList) {
								if(authId.equals(tbAuthority.getAuthId()))
									r.setCheck(true);
							}
							BeanUtils.copyProperties(tbAuthority, r);
							children.add(r);
						}
						tbAuthorityResData.setChildren(children);
						if(!CollectionUtils.isEmpty(children)) {
							subFunction(tbAuthorityList,children,authIdList);
						}
					}
				}
				
			}
		}
	}

}
