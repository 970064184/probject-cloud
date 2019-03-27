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
	@Query(value="SELECT a.auth_url FROM tb_authority a WHERE a.auth_id IN(?1)  and is_hide = 0",nativeQuery=true)
	List<String> findAuthUrlByAuthIdIn(List<Long> authIdList);
	
	/**
	 * 根据类型查出记录
	 * @param authType
	 * @return
	 */
	@Query("select t from TbAuthority t where authType = ?1 and isHide = 0 order by sort asc")
	List<TbAuthority> findByAuthTypeAndIsHide(Integer authType);
	
	TbAuthority findByAuthNameAndIsHide(String authName,int isHide);
	/**
	 * 查询有效记录
	 * @return
	 */
	@Query("select t from TbAuthority t where isHide = 0 order by sort asc")
	List<TbAuthority> findAllByIsHide();
	/**
	 * 根据一批权限id查询权限记录
	 * @param authList
	 * @return
	 */
	@Query("select t from TbAuthority t where t.authId IN(?1) and isHide = 0")
	List<TbAuthority> findByAuthIdIn(List<Long> authList);
}
