package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 移交书
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
public class TransferTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 移交书id
 	 */
	private String transferTableId;
	/**
  	 * 检查人员id
 	 */
	private Integer policeId;
	/**
  	 * 场所id
 	 */
	private Integer unitId;
	/**
  	 * 场所名称
 	 */
	private String unitName;
	/**
  	 * 场所地址
 	 */
	private String address;
	/**
  	 * 建筑面试
 	 */
	private BigDecimal area;
	/**
  	 * 建筑层数
 	 */
	private Integer floors;
	/**
  	 * 建筑高度

 	 */
	private BigDecimal height;
	/**
  	 * 是否达标 0未达标，1达标
 	 */
	private Long level;
	/**
  	 * 隐患
 	 */
	private String danger;
	/**
  	 * 接管单位
 	 */
	private String handlUnit;
	/**
  	 * 详细资料
 	 */
	private String datails;
	/**
  	 * 创建时间
 	 */
	private Date createDate;

	/**
	 * 设置：移交书id
	 */
	public void setTransferTableId(String transferTableId) {
		this.transferTableId = transferTableId;
	}
	/**
	 * 获取：移交书id
	 */
	public String getTransferTableId() {
		return transferTableId;
	}
	/**
	 * 设置：检查人员id
	 */
	public void setPoliceId(Integer policeId) {
		this.policeId = policeId;
	}
	/**
	 * 获取：检查人员id
	 */
	public Integer getPoliceId() {
		return policeId;
	}
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
	 * 设置：建筑面试
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	/**
	 * 获取：建筑面试
	 */
	public BigDecimal getArea() {
		return area;
	}
	/**
	 * 设置：建筑层数
	 */
	public void setFloors(Integer floors) {
		this.floors = floors;
	}
	/**
	 * 获取：建筑层数
	 */
	public Integer getFloors() {
		return floors;
	}
	/**
	 * 设置：建筑高度

	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	/**
	 * 获取：建筑高度

	 */
	public BigDecimal getHeight() {
		return height;
	}
	/**
	 * 设置：是否达标 0未达标，1达标
	 */
	public void setLevel(Long level) {
		this.level = level;
	}
	/**
	 * 获取：是否达标 0未达标，1达标
	 */
	public Long getLevel() {
		return level;
	}
	/**
	 * 设置：隐患
	 */
	public void setDanger(String danger) {
		this.danger = danger;
	}
	/**
	 * 获取：隐患
	 */
	public String getDanger() {
		return danger;
	}
	/**
	 * 设置：接管单位
	 */
	public void setHandlUnit(String handlUnit) {
		this.handlUnit = handlUnit;
	}
	/**
	 * 获取：接管单位
	 */
	public String getHandlUnit() {
		return handlUnit;
	}
	/**
	 * 设置：详细资料
	 */
	public void setDatails(String datails) {
		this.datails = datails;
	}
	/**
	 * 获取：详细资料
	 */
	public String getDatails() {
		return datails;
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
