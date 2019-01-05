package com.zhangbin.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.TbUser;

@Repository
public interface UserRepository extends JpaRepository<TbUser, Long>, JpaSpecificationExecutor<TbUser> {
	
	TbUser findByUserName(String userName);
}
