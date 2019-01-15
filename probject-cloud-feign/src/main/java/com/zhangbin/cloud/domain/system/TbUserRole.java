package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_user_roles database table.
 * 
 */
@Entity
@Table(name="tb_user_roles")
public class TbUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="role_id")
	private Long roleId;

	@Column(name="user_id")
	private Long userId;

	public TbUserRole() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}