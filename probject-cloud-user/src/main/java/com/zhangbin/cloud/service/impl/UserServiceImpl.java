package com.zhangbin.cloud.service.impl;

import com.zhangbin.cloud.common.CodeEnum;
import com.zhangbin.cloud.common.PageBean;
import com.zhangbin.cloud.common.PageBeanUtils;
import com.zhangbin.cloud.common.PageData;
import com.zhangbin.cloud.controller.system.resData.AllUserResp;
import com.zhangbin.cloud.controller.system.resData.ImportUser;
import com.zhangbin.cloud.domain.system.TbUser;
import com.zhangbin.cloud.exception.BusinessException;
import com.zhangbin.cloud.feign.resData.AddUserReq;
import com.zhangbin.cloud.feign.resData.EditUserReq;
import com.zhangbin.cloud.repository.UserRepository;
import com.zhangbin.cloud.service.*;
import com.zhangbin.cloud.utils.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private TbRolesMenuService tbRolesMenuService;
	@Autowired
	private AuthorityService authorityService;

	@Override
	public TbUser findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public TbUser findByOne(Long userId) {
		return userRepository.findById(userId).get();
	}
	
	
	@Override
	public List<String> findRoleByUserId(Long userId) {
		// 获得该用户角色
		List<String> roleCodeList = new ArrayList<>();
		List<Long> roleId = userRoleService.findByUserId(userId);
		if (!CollectionUtils.isEmpty(roleId)) {
			roleCodeList = roleService.findByRoleIdIn(roleId);
		}
		return roleCodeList;
	}

	@Override
	public List<String> findAuthorityByUserId(Long userId) {
		// 每个角色拥有默认的权限
		List<String> authUrlList = new ArrayList<>();
		List<Long> roleId = userRoleService.findByUserId(userId);
		List<Long> authList = tbRolesMenuService.findByRoleIdIn(roleId);
		if (!CollectionUtils.isEmpty(authList)) {
			authUrlList = authorityService.findAuthUrlByAuthIdIn(authList);
		}
		return authUrlList;
	}

	@Override
	@Transactional
	public Long addUser(AddUserReq addUserReq) {
		TbUser user = userRepository.findByUserName(addUserReq.getUserName());
		if(user !=null) {
			throw new BusinessException(CodeEnum.USER_USERNAME_ISEXIST);
		}
		TbUser findByUserPhone = userRepository.findByUserPhone(addUserReq.getUserPhone());
		if(findByUserPhone !=null) {
			throw new BusinessException(CodeEnum.USER_USERPHONE_ISEXIST);
		}
		TbUser tbUser = new TbUser();
		BeanUtils.copyProperties(addUserReq, tbUser);
		tbUser.setCreated(new Date());
		tbUser.setRegistType(1);//注册类型(1=系统录入，2=注册)
		return userRepository.save(tbUser).getUserId();
	}

	@Override
	public Long editUser(EditUserReq editUserReq) {
		TbUser findOne = userRepository.findById(editUserReq.getUserId()).get();
		if(findOne ==null) {
			throw new BusinessException(CodeEnum.SYSTEM_USERNAME_ISNOTEXIST);
		}
		TbUser user = userRepository.findRepeatByUserName(editUserReq.getUserName(),editUserReq.getUserId());
		if(user !=null) {
			throw new BusinessException(CodeEnum.USER_USERNAME_ISEXIST);
		}
		TbUser findByUserPhone = userRepository.findRepeatByUserPhone(editUserReq.getUserPhone(),editUserReq.getUserId());
		if(findByUserPhone !=null) {
			throw new BusinessException(CodeEnum.USER_USERPHONE_ISEXIST);
		}
		BeanUtils.copyProperties(editUserReq, findOne);
		Long userId = userRepository.save(findOne).getUserId();
		return userId;
	}

	@Override
	public PageData<AllUserResp> findAllUserByPage(PageBean pageBean) {
		Map<String, Direction> map = new HashMap<>();
		map.put("created", Direction.DESC);
		PageRequest pageRequest = PageBeanUtils.pageRequest(pageBean.getPage(), pageBean.getLimit(), map);
		Page<TbUser> findAll = userRepository.findAll(pageRequest);
		List<TbUser> list = findAll.getContent();
		List<AllUserResp> allUserResp = new ArrayList<>();
		allUserResp = BeanUtil.createBean(list, AllUserResp.class);
		PageData<AllUserResp> pageData = new PageData<>(findAll.getTotalElements(),allUserResp);
		return pageData;
	}

	@Override
	@Transactional
	public void delUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	@Transactional
	public void saveListUser(List<ImportUser> importUser) {
		List<TbUser> tbUserList = new ArrayList<>();
		List<String> userNameList = new ArrayList<>();
		userNameList = importUser.stream().map((f)->f.getUserName()).collect(Collectors.toList());
		List<String> userPhoneList = new ArrayList<>();
		userPhoneList = importUser.stream().map((f)->f.getUserPhone()).collect(Collectors.toList());
		/**
		 * 查用户和手机号码重名
		 */
		List<TbUser> findByUserNameIn = userRepository.findByUserNameIn(userNameList);
		if(!CollectionUtils.isEmpty(findByUserNameIn))
			throw new BusinessException(CodeEnum.USER_USERNAME_IN_ISEXIST,findByUserNameIn.stream().map((m)->m.getUserName()).collect(Collectors.toList()));
		List<TbUser> findByUserPhoneIn = userRepository.findByUserPhoneIn(userPhoneList);
		if(!CollectionUtils.isEmpty(findByUserPhoneIn))
			throw new BusinessException(CodeEnum.USER_USERPHONE_IN_ISEXIST,findByUserPhoneIn.stream().map((m)->m.getUserPhone()).collect(Collectors.toList()));
		tbUserList = BeanUtil.createBean(importUser, TbUser.class);
		tbUserList.forEach((f)->{
			f.setUserPwd("123");
			f.setCreated(new Date());
			f.setRegistType(1);//注册类型(1=系统录入，2=注册)
		});
		userRepository.saveAll(tbUserList);
	}
}
