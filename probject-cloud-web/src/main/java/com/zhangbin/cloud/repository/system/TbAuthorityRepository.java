package com.zhangbin.cloud.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbAuthority;

@Repository
public interface TbAuthorityRepository extends JpaRepository<TbAuthority, Long>, JpaSpecificationExecutor<TbAuthority> {

}
