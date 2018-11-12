/*package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;


*//**
 * The persistent class for the tb_menu database table.
 * 
 *//*
@Data
@Entity
@Table(name="tb_menu")
public class TbMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;

	private Date created;

	@Column(name="is_hide")
	private short isHide;

	@Column(length=200)
	private String logo;

	@Column(nullable=false, length=200)
	private String name;

	@Column(name="p_id")
	private BigInteger pId;

	private int sort;

	private Date updated;

	@Column(length=200)
	private String url;
}*/