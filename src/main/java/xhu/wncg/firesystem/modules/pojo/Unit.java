package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 场所表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 场所id
 	 */
	private Integer unitId;
	/**
  	 * 所属派出所id
 	 */
	private Integer policeStationId;
	/**
  	 * 场所名称
 	 */
	private String unitName;
	/**
  	 * 法定代表人
 	 */
	private String master;
	/**
  	 * 场所地址
 	 */
	private String address;
	/**
  	 * 场所性质
 	 */
	private String unitProperty;
	/**
  	 * 场所面积
 	 */
	private BigDecimal area;
	/**
  	 * 楼层
 	 */
	private Integer floors;
	/**
  	 * 高度
 	 */
	private BigDecimal height;
	/**
  	 * 检查状态 0未检查，1检查
 	 */
	private Integer status;
	/**
  	 * 检查类型
 	 */
	private Integer checkType;
	/**
  	 * 创建日期
 	 */
	private Date createDate;

	/**
	 * 设置：场所id
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：场所id
	 */
	public Integer getUnitId() {
		return unitId;
	}
	/**
	 * 设置：所属派出所id
	 */
	public void setPoliceStationId(Integer policeStationId) {
		this.policeStationId = policeStationId;
	}
	/**
	 * 获取：所属派出所id
	 */
	public Integer getPoliceStationId() {
		return policeStationId;
	}
	/**
	 * 设置：场所名称
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	/**
	 * 获取：场所名称
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * 设置：法定代表人
	 */
	public void setMaster(String master) {
		this.master = master;
	}
	/**
	 * 获取：法定代表人
	 */
	public String getMaster() {
		return master;
	}
	/**
	 * 设置：场所地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：场所地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：场所性质
	 */
	public void setUnitProperty(String unitProperty) {
		this.unitProperty = unitProperty;
	}
	/**
	 * 获取：场所性质
	 */
	public String getUnitProperty() {
		return unitProperty;
	}
	/**
	 * 设置：场所面积
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	/**
	 * 获取：场所面积
	 */
	public BigDecimal getArea() {
		return area;
	}
	/**
	 * 设置：楼层
	 */
	public void setFloors(Integer floors) {
		this.floors = floors;
	}
	/**
	 * 获取：楼层
	 */
	public Integer getFloors() {
		return floors;
	}
	/**
	 * 设置：高度
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	/**
	 * 获取：高度
	 */
	public BigDecimal getHeight() {
		return height;
	}
	/**
	 * 设置：检查状态 0未检查，1检查
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：检查状态 0未检查，1检查
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：检查类型
	 */
	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	/**
	 * 获取：检查类型
	 */
	public Integer getCheckType() {
		return checkType;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
