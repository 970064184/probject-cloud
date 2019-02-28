package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbAuthority;

@Repository
public interface AuthorityRepository extends JpaRepository<TbAuthority,Long>, JpaSpecificationExecutor<TbAuthority> {
	
	/**
	 * 
	 * @param authIdList
	 * @return
	 */
	@Query(value="SELECT a.auth_url FROM tb_authority a WHERE a.auth_id IN(?1) ",nativeQuery=true)
	public List<String> findByAuthIdIn(List<Long> authIdList);
	
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	@Query("select t from TbAuthority t where authType = ?1 and isHide = 0 order by sort asc")
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);
}
