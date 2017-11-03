package xhu.wncg.firesystem.modules.controller.vo;

import xhu.wncg.firesystem.modules.pojo.Unit;

/**
 * 场所表
 *
 * @author zhaobo
 * @email 15528330581@163.com
 * @version 2017-11-02 15:58:16
 */
public class UnitVO extends Unit {
    /**
     * 场所性质
     */
    private String property;

    /**
     * 场所数量
     */
    private Integer number;

    public String getProperty() {
        return property;
    }

    public UnitVO setProperty(String property) {
        this.property = property;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public UnitVO setNumber(Integer number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "UnitVO{" +
                "property='" + property + '\'' +
                ", number=" + number +
                '}';
    }
}
