package xhu.wncg.firesystem.modules.controller.qo;

import xhu.wncg.firesystem.modules.pojo.Unit;

/**
 * 场所表
 *
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class UnitQO extends Unit {
    String countKeys;
    String startTime;
    String endTime;

    public String getCountKeys() {
        return countKeys;
    }

    public void setCountKeys(String countKeys) {
        this.countKeys = countKeys;
    }

    public String getStartTime() {
        String str=String.format("yyyy-MM-dd HH:mm:ss",startTime);
        return str;
    }

    public void setStartTime(String startTime) {
        this.startTime=startTime;
    }

    public String getEndTime() {
        String str=String.format("yyyy-MM-dd HH:mm:ss",endTime);
        return str;
    }

    public void setEndTime(String endTime) {
        this.endTime=endTime;
    }


}