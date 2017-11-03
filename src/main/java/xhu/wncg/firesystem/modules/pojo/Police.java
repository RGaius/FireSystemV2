package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 警员表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class Police implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 警号

 	 */
	private String policeId;
	/**
  	 * 所属派出所
 	 */
	private Integer policeStationId;
	/**
  	 * 电话号码
 	 */
	private Integer moblie;
	/**
  	 * 名字
 	 */
	private String relName;
	/**
  	 * 创建时间
 	 */
	private Date createDate;

	/**
	 * 设置：警号

	 */
	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}
	/**
	 * 获取：警号

	 */
	public String getPoliceId() {
		return policeId;
	}
	/**
	 * 设置：所属派出所
	 */
	public void setPoliceStationId(Integer policeStationId) {
		this.policeStationId = policeStationId;
	}
	/**
	 * 获取：所属派出所
	 */
	public Integer getPoliceStationId() {
		return policeStationId;
	}
	/**
	 * 设置：电话号码
	 */
	public void setMoblie(Integer moblie) {
		this.moblie = moblie;
	}
	/**
	 * 获取：电话号码
	 */
	public Integer getMoblie() {
		return moblie;
	}
	/**
	 * 设置：名字
	 */
	public void setRelName(String relName) {
		this.relName = relName;
	}
	/**
	 * 获取：名字
	 */
	public String getRelName() {
		return relName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
