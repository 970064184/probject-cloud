package com.zhangbin.cloud.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the tb_authority database table.
 * 
 */
@Entity
@Table(name="tb_authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class TbAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="auth_id", unique=true, nullable=false)
	private Long authId;

	@Column(name="auth_logo", length=200)
	private String authLogo;

	@Column(name="auth_name", nullable=false, length=200)
	private String authName;

	@Column(name="auth_type"/*,columnDefinition = "Integer default 2"*/)
	private Integer authType;

	@Column(name="auth_url", length=200)
	private String authUrl;

	private Date created;

	@Column(name="is_hide")
	private Integer isHide;

	@Column(name="p_id")
	private Long pid;

	@Column(name = "sort"/*,columnDefinition = "Integer default 0"*/)
	private Integer sort;

	private Date updated;
}