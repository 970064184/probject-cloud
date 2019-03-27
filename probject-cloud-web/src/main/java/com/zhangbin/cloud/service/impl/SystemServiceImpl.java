package com.zhangbin.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangbin.cloud.controller.system.resData.TbAuthorityResData;
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

	@Override
	public List<TbAuthorityResData> findByAuthTypeAndIsHide(Integer authType) {
		List<TbAuthority> tbAuthorityList = tbAuthorityRepository.findByAuthTypeAndIsHide(2);
		List<TbAuthorityResData> list= new ArrayList<>();
		if(!CollectionUtils.isEmpty(tbAuthorityList)) {
			for (TbAuthority t : tbAuthorityList) {
				if (t.getPId() == null) {
					TbAuthorityResData r = new TbAuthorityResData();
					BeanUtils.copyProperties(t, r);
					list.add(r);
				}
			}
			subFunction(tbAuthorityList, list);
			
		}
		return list;
	}
	/**
	 * 子菜单递归生成函数
	 * @param tbAuthorityList
	 * @param list
	 */
	private void subFunction(List<TbAuthority> tbAuthorityList, List<TbAuthorityResData> list) {
		if(!CollectionUtils.isEmpty(list)) {
			tbAuthorityList.removeAll(list);
			if(!CollectionUtils.isEmpty(tbAuthorityList)) {
				for (TbAuthorityResData tbAuthorityResData : list) {
					List<TbAuthorityResData> children = new ArrayList<>();
					for (TbAuthority tbAuthority : tbAuthorityList) {
						if(tbAuthorityResData.getAuthId().equals(tbAuthority.getPId())) {
							TbAuthorityResData r = new TbAuthorityResData();
							BeanUtils.copyProperties(tbAuthority, r);
							children.add(r);
						}
						tbAuthorityResData.setChildren(children);
						if(!CollectionUtils.isEmpty(children)) {
							subFunction(tbAuthorityList,children);
						}
					}
				}
				
			}
		}
	}

}