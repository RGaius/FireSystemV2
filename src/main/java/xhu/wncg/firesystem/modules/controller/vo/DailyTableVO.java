package xhu.wncg.firesystem.modules.controller.vo;

import xhu.wncg.firesystem.modules.pojo.DailyTable;
import xhu.wncg.firesystem.modules.pojo.Picture;
import xhu.wncg.firesystem.modules.pojo.Unit;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * 日常检查表
 *
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class DailyTableVO extends DailyTable {
    /**
     * 场所图片
     */
    private List<Picture> pictures;

    /**
     * 场所基本信息
     */
    private Unit unit;

    public List<Picture> getPicture() {
        return pictures;
    }

    public DailyTableVO setPicture(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Unit getUnit() {
        return unit;
    }

    public DailyTableVO setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * 场所数量
     */
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public DailyTableVO setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Map map;
    public void setMap(Map map) {
        this.map = map;
    }
}