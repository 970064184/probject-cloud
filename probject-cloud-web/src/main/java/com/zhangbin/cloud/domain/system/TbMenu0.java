package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


/**
 * The persistent class for the tb_menu database table.
 * 
 */
@Data
@Entity
@Table(name="tb_menu")
public class TbMenu0 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;
	
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
	
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updated;

	@Column(length=200)
	private String url;
}