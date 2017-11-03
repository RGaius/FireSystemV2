package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 日常检查表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class DailyTable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 日常检查记录表id
 	 */
	private Integer dailyTableId;
	/**
  	 * 检查人员id
 	 */
	private Integer policeId;
	/**
  	 * 场所id
 	 */
	private Integer unitId;
	/**
  	 * 检查人员名称
 	 */
	private String checker;
	/**
  	 * 陪同检查人员
 	 */
	private String otherChecker;
	/**
  	 * 存在问题
 	 */
	private String problem;
	/**
  	 * 备注
 	 */
	private String remark;
	/**
  	 * 创建日期
 	 */
	private Date createDate;
	/**
  	 * 是否通过 0未通过，1通过
 	 */
	private Integer status;

	/**
	 * 设置：日常检查记录表id
	 */
	public void setDailyTableId(Integer dailyTableId) {
		this.dailyTableId = dailyTableId;
	}
	/**
	 * 获取：日常检查记录表id
	 */
	public Integer getDailyTableId() {
		return dailyTableId;
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
	 * 设置：检查人员名称
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}
	/**
	 * 获取：检查人员名称
	 */
	public String getChecker() {
		return checker;
	}
	/**
	 * 设置：陪同检查人员
	 */
	public void setOtherChecker(String otherChecker) {
		this.otherChecker = otherChecker;
	}
	/**
	 * 获取：陪同检查人员
	 */
	public String getOtherChecker() {
		return otherChecker;
	}
	/**
	 * 设置：存在问题
	 */
	public void setProblem(String problem) {
		this.problem = problem;
	}
	/**
	 * 获取：存在问题
	 */
	public String getProblem() {
		return problem;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	/**
	 * 设置：是否通过 0未通过，1通过
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否通过 0未通过，1通过
	 */
	public Integer getStatus() {
		return status;
	}
}
