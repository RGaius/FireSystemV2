package xhu.wncg.firesystem.modules.controller.qo;

import xhu.wncg.firesystem.modules.pojo.DailyTable;

/**
 * 日常检查表
 *
 * @author zhaobo
 * @version 2017-11-02 15:58:16
 * @email 15528330581@163.com
 */
public class DailyTableQO extends DailyTable {
    private String begindate;
    private String enddate;

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}