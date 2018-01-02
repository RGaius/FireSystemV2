package xhu.wncg.firesystem.modules.pojo;

public enum DateType {
    /**
     * 枚举dateType四种方式
     */
    Day(0),
    Week(1),
    Month(2),
    Year(3);


    private int datetype;

    DateType(int code) {
        this.datetype = code;
    }

    public int getCode() {
        return datetype;
    }

    public void setCode(int code) {
        this.datetype = code;
    }

    /**
     * 根据value返回枚举类型,主要在switch中使用
     *
     * @param value
     * @return
     */
    public static DateType getByValue(int value) {
        for (DateType datetype : values()) {
            if (datetype.getCode() == value) {
                return datetype;
            }
        }
        return null;
    }
}
