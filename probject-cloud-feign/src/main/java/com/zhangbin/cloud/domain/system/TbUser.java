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
	private int bloodType;

	private Date created;

	private int eduction;

	@Column(name="live_address", length=200)
	private String liveAddress;

	@Column(name="login_time")
	private Date loginTime;

	@Column(name="regist_type")
	private int registType;

	private int sex;

	private int sort;

	private int status;

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

	public int getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(int bloodType) {
		this.bloodType = bloodType;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getEduction() {
		return this.eduction;
	}

	public void setEduction(int eduction) {
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

	public int getRegistType() {
		return this.registType;
	}

	public void setRegistType(int registType) {
		this.registType = registType;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
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