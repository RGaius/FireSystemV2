package xhu.wncg.firesystem.modules.controller.qo;

import xhu.wncg.firesystem.modules.pojo.Unit;

import java.sql.Date;

/**
 * 场所表
 *
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class UnitQO extends Unit {
    String countKeys;

    public String getCountKeys() {
        return countKeys;
    }

    public void setCountKeys(String countKeys) {
        this.countKeys = countKeys;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    Date startTime;
    Date endTime;
}