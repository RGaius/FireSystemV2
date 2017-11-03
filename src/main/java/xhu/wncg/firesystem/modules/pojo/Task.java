package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 任务表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 任务ID
 	 */
	private Integer taskId;
	/**
  	 * 所属场所ID

 	 */
	private Integer unitId;
	/**
  	 * 任务时长（天）
 	 */
	private Integer taskTime;
	/**
  	 * 开始时间
 	 */
	private Date startDate;
	/**
  	 * 创建时间
 	 */
	private Date createDate;
	/**
  	 * 更新时间
 	 */
	private Date updateDate;

	/**
	 * 设置：任务ID
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取：任务ID
	 */
	public Integer getTaskId() {
		return taskId;
	}
	/**
	 * 设置：所属场所ID

	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：所属场所ID

	 */
	public Integer getUnitId() {
		return unitId;
	}
	/**
	 * 设置：任务时长（天）
	 */
	public void setTaskTime(Integer taskTime) {
		this.taskTime = taskTime;
	}
	/**
	 * 获取：任务时长（天）
	 */
	public Integer getTaskTime() {
		return taskTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDate() {
		return startDate;
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
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
