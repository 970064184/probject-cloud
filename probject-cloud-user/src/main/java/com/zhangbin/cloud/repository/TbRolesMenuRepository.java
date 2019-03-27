package com.zhangbin.cloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zhangbin.cloud.domain.system.TbRolesMenu;
@Repository
public interface TbRolesMenuRepository extends JpaRepository<TbRolesMenu, Long>, JpaSpecificationExecutor<TbRolesMenu> {
	/**
	 * 根据用户角色id查找权限id
	 * @param roleId
	 * @return
	 */
	@Query(value="SELECT m.`auth_id` FROM tb_roles_menu m WHERE m.`role_id` IN(?1)",nativeQuery=true)
	public List<Long> findByRoleIdIn(List<Long> roleId);
	/**
	 * 根据用户角色id查找权限id
	 * @param roleId
	 * @return
	 */
	@Query(value="SELECT m.`auth_id` FROM tb_roles_menu m WHERE m.`role_id` =?1",nativeQuery=true)
	public List<Long> findByRoleId(Long roleId);
	
}
