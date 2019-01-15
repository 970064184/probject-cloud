package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbAuthority;

@Repository
public interface AuthorityRepository extends JpaRepository<TbAuthority,Long>, JpaSpecificationExecutor<TbAuthority> {
	
	@Query(value="SELECT a.auth_url FROM tb_authority a WHERE a.auth_id IN(?1) ",nativeQuery=true)
	public List<String> findByAuthIdIn(List<Long> authIdList);
}
