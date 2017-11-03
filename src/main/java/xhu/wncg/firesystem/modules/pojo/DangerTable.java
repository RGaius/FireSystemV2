package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 火灾隐患报告书
 *
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:15
 */
public class DangerTable implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 隐患报告书id
	 */
	private String dangerTableId;
	/**
	 * 检查人员id

	 */
	private String policeId;
	/**
	 * 所属场所id
	 */
	private Integer unitId;
	/**
	 * 机构名称
	 */
	private String agencyName;
	/**
	 * 年
	 */
	private String year;
	/**
	 * 月
	 */
	private String month;
	/**
	 * 日
	 */
	private String day;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger1;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger2;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger3;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger4;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger5;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private Long danger6;
	/**
	 * 存在隐患 0 不存在，1 存在
	 */
	private String otherDanger;
	/**
	 *
	 */
	private Date createDate;

	/**
	 * 设置：隐患报告书id
	 */
	public void setDangerTableId(String dangerTableId) {
		this.dangerTableId = dangerTableId;
	}
	/**
	 * 获取：隐患报告书id
	 */
	public String getDangerTableId() {
		return dangerTableId;
	}
	/**
	 * 设置：检查人员id

	 */
	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}
	/**
	 * 获取：检查人员id

	 */
	public String getPoliceId() {
		return policeId;
	}
	/**
	 * 设置：所属场所id
	 */
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	/**
	 * 获取：所属场所id
	 */
	public Integer getUnitId() {
		return unitId;
	}
	/**
	 * 设置：机构名称
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	/**
	 * 获取：机构名称
	 */
	public String getAgencyName() {
		return agencyName;
	}
	/**
	 * 设置：年
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取：月
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 设置：日
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * 获取：日
	 */
	public String getDay() {
		return day;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger1(Long danger1) {
		this.danger1 = danger1;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger1() {
		return danger1;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger2(Long danger2) {
		this.danger2 = danger2;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger2() {
		return danger2;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger3(Long danger3) {
		this.danger3 = danger3;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger3() {
		return danger3;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger4(Long danger4) {
		this.danger4 = danger4;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger4() {
		return danger4;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger5(Long danger5) {
		this.danger5 = danger5;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger5() {
		return danger5;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setDanger6(Long danger6) {
		this.danger6 = danger6;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public Long getDanger6() {
		return danger6;
	}
	/**
	 * 设置：存在隐患 0 不存在，1 存在
	 */
	public void setOtherDanger(String otherDanger) {
		this.otherDanger = otherDanger;
	}
	/**
	 * 获取：存在隐患 0 不存在，1 存在
	 */
	public String getOtherDanger() {
		return otherDanger;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
