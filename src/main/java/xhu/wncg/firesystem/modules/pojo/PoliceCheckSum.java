package xhu.wncg.firesystem.modules.pojo;

public class PoliceCheckSum {
    /**
     * 日期
     */
    private String Date;

    /**
     * 一年中第几周
     */
    private String weekOfYear;

    /**
     * 一年中第几个月
     */
    private String monthOfYear;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 数量
     */
    private int ammount;

    /**
     * 维度信息，chart x 柱 字符
     */
    private String dimensionValue;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getWeekOfYear() {
        return weekOfYear;
    }

    public void setWeekOfYear(String weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public String getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(String monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getDimensionValue() {
        return dimensionValue;
    }

    public void setDimensionValue(String dimensionValue) {
        this.dimensionValue = dimensionValue;
    }
}
