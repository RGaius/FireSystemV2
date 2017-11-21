package xhu.wncg.common.exception;

/**
 * 自定义异常
 *
 * @author BZhao
 * @version 2017/10/24.
 */
public class FireException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public FireException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public FireException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public FireException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public FireException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
