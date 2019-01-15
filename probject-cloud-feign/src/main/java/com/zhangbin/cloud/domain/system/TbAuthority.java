package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_authority database table.
 * 
 */
@Entity
@Table(name="tb_authority")
public class TbAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="auth_id", unique=true, nullable=false)
	private Long authId;

	@Column(name="auth_logo", length=200)
	private String authLogo;

	@Column(name="auth_name", nullable=false, length=200)
	private String authName;

	@Column(name="auth_type")
	private Integer authType;

	@Column(name="auth_url", length=200)
	private String authUrl;

	private Date created;

	@Column(name="is_hide")
	private Integer isHide;

	@Column(name="p_id")
	private Long pId;

	private Integer sort;

	private Date updated;

	public TbAuthority() {
	}

	public Long getAuthId() {
		return this.authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public String getAuthLogo() {
		return this.authLogo;
	}

	public void setAuthLogo(String authLogo) {
		this.authLogo = authLogo;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Integer getAuthType() {
		return this.authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public String getAuthUrl() {
		return this.authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getIsHide() {
		return this.isHide;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}

	public Long getPId() {
		return this.pId;
	}

	public void setPId(Long pId) {
		this.pId = pId;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}