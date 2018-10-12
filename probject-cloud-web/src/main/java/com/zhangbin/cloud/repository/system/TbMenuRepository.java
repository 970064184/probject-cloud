package com.zhangbin.cloud.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zhangbin.cloud.domain.system.TbMenu;

public interface TbMenuRepository extends JpaRepository<TbMenu, String>, JpaSpecificationExecutor<TbMenu> {

}
