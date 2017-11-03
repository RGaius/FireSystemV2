package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 派出所表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class PoliceStation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 派出所id
 	 */
	private Integer policeStationId;
	/**
  	 * 分局id
 	 */
	private Integer branchId;
	/**
  	 * 派出所名称
 	 */
	private String policeStation;

	/**
	 * 设置：派出所id
	 */
	public void setPoliceStationId(Integer policeStationId) {
		this.policeStationId = policeStationId;
	}
	/**
	 * 获取：派出所id
	 */
	public Integer getPoliceStationId() {
		return policeStationId;
	}
	/**
	 * 设置：分局id
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	/**
	 * 获取：分局id
	 */
	public Integer getBranchId() {
		return branchId;
	}
	/**
	 * 设置：派出所名称
	 */
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	/**
	 * 获取：派出所名称
	 */
	public String getPoliceStation() {
		return policeStation;
	}
}
