package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbRole;

@Repository
public interface RoleRepository extends JpaRepository<TbRole, Long>, JpaSpecificationExecutor<TbRole> {
	
	/**
	 * 根据角色id查找角色编码
	 * @param roleid
	 * @return
	 */
	@Query(value="SELECT ro.role_code FROM tb_roles ro WHERE ro.role_id IN (?1)",nativeQuery=true)
	public List<String> findByRoleIdIn(List<Long> roleid);
	
	/**
	 * 根据角色名称查询记录
	 * @param roleName
	 * @return
	 */
	public TbRole findByRoleName(String roleName);
}
