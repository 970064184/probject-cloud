package com.zhangbin.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbUserRole;
import java.lang.Long;
import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository<TbUserRole, Long>, JpaSpecificationExecutor<TbUserRole> {
	
	/**
	 * 根据用户id查询用户角色id
	 * @param userid
	 * @return
	 */
	@Query(value ="SELECT r.role_id FROM tb_user_roles r WHERE r.user_id=?1",nativeQuery=true)
	public List<Long> findByUserId(Long userid);
}
