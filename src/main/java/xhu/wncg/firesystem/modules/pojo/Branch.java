package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 公安分局表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 
 	 */
	private Integer branchId;
	/**
  	 * 分局名称
 	 */
	private String branchName;

	/**
	 * 设置：
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	/**
	 * 获取：
	 */
	public Integer getBranchId() {
		return branchId;
	}
	/**
	 * 设置：分局名称
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * 获取：分局名称
	 */
	public String getBranchName() {
		return branchName;
	}
}
