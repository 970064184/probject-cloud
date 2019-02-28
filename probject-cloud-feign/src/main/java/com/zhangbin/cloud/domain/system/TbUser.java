package com.zhangbin.cloud.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
public class TbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id", unique=true, nullable=false, length=32)
	private Long userId;

	@Column(name="birth_address", length=200)
	private String birthAddress;

	private Date birthday;

	@Column(name="blood_type")
	private Integer bloodType;

	private Date created;

	private Integer eduction;

	@Column(name="live_address", length=200)
	private String liveAddress;

	@Column(name="login_time")
	private Date loginTime;

	@Column(name="regist_type")
	private Integer registType;

	private Integer sex;

	private Integer sort;

	private Integer status;

	private Date updated;

	@Column(name="user_email", length=100)
	private String userEmail;

	@Column(name="user_logo", length=200)
	private String userLogo;

	@Column(name="user_name", nullable=false, length=200)
	private String userName;

	@Column(name="user_phone", length=20)
	private String userPhone;

	@Column(name="user_pwd", nullable=false, length=100)
	private String userPwd;

	@Column(length=200)
	private String work;

	public TbUser() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBirthAddress() {
		return this.birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(Integer bloodType) {
		this.bloodType = bloodType;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getEduction() {
		return this.eduction;
	}

	public void setEduction(Integer eduction) {
		this.eduction = eduction;
	}

	public String getLiveAddress() {
		return this.liveAddress;
	}

	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getRegistType() {
		return this.registType;
	}

	public void setRegistType(Integer registType) {
		this.registType = registType;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLogo() {
		return this.userLogo;
	}

	public void setUserLogo(String userLogo) {
		this.userLogo = userLogo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

}