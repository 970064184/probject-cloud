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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * The persistent class for the tb_menu database table.
 * 
 */
@ApiModel(value ="tbMenu对象",description="菜单对象tbMenu")
@Data
@Entity
@Table(name="tb_menu")
public class TbMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value ="菜单ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private String id;
	
	@ApiModelProperty(value="创建时间")
	private Date created;
	
	@ApiModelProperty(value="是否隐藏,0:否,1:是")
	@Column(name="is_hide")
	private short isHide;

	@Column(length=200)
	private String logo;

	@Column(nullable=false, length=200)
	private String name;

	@Column(name="p_id")
	private BigInteger pId;

	private int sort;
	
	@ApiModelProperty(value="更新时间")
	private Date updated;

	@Column(length=200)
	private String url;
}