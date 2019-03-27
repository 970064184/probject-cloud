package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SRT_STORE_QR database table.
 * 
 */
@Entity
@Table(name="SRT_STORE_QR")
@NamedQuery(name="SrtStoreQr.findAll", query="SELECT s FROM SrtStoreQr s")
public class SrtStoreQr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QR_ID", unique=true, nullable=false, length=32)
	private String qrId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="QR_DESC", length=30)
	private String qrDesc;

	@Column(name="QR_URL", length=500)
	private String qrUrl;

	@Column(name="STORE_ID", length=32)
	private String storeId;

	@Column(name="TABLE_NUMBER", length=30)
	private String tableNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_TIME")
	private Date updateTime;

	public SrtStoreQr() {
	}

	public String getQrId() {
		return this.qrId;
	}

	public void setQrId(String qrId) {
		this.qrId = qrId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getQrDesc() {
		return this.qrDesc;
	}

	public void setQrDesc(String qrDesc) {
		this.qrDesc = qrDesc;
	}

	public String getQrUrl() {
		return this.qrUrl;
	}

	public void setQrUrl(String qrUrl) {
		this.qrUrl = qrUrl;
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}