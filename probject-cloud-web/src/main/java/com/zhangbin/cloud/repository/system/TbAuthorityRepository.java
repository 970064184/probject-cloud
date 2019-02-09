package com.zhangbin.cloud.repository.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbAuthority;

@Repository
public interface TbAuthorityRepository extends JpaRepository<TbAuthority, Long>, JpaSpecificationExecutor<TbAuthority> {
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	@Query("select t from TbAuthority t where authType = ?1 and isHide = 0 order by sort asc")
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);
}
