package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_roles_menu database table.
 * 
 */
@Entity
@Table(name="tb_roles_menu")
public class TbRolesMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="auth_id")
	private Long authId;

	@Column(name="role_id")
	private Long roleId;

	public TbRolesMenu() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthId() {
		return this.authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}