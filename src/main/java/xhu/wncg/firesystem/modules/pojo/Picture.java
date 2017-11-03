package xhu.wncg.firesystem.modules.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 表册图片表
 * 
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
  	 * 图片id
 	 */
	private Integer pictureId;
	/**
  	 * 日常检查表册id
 	 */
	private Integer dailyTableId;
	/**
  	 * 图片类型
 	 */
	private Integer pictureType;
	/**
  	 * 图片地址
 	 */
	private String pictureUrl;
	/**
  	 * 上传日期
 	 */
	private Date createDate;

	/**
	 * 设置：图片id
	 */
	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}
	/**
	 * 获取：图片id
	 */
	public Integer getPictureId() {
		return pictureId;
	}
	/**
	 * 设置：日常检查表册id
	 */
	public void setDailyTableId(Integer dailyTableId) {
		this.dailyTableId = dailyTableId;
	}
	/**
	 * 获取：日常检查表册id
	 */
	public Integer getDailyTableId() {
		return dailyTableId;
	}
	/**
	 * 设置：图片类型
	 */
	public void setPictureType(Integer pictureType) {
		this.pictureType = pictureType;
	}
	/**
	 * 获取：图片类型
	 */
	public Integer getPictureType() {
		return pictureType;
	}
	/**
	 * 设置：图片地址
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}
	/**
	 * 设置：上传日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：上传日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
