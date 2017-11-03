package xhu.wncg.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class Fire extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Fire() {
		put("code", 0);
	}
	
	public static Fire error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static Fire error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static Fire error(int code, String msg) {
		Fire fire = new Fire();
		fire.put("code", code);
		fire.put("msg", msg);
		return fire;
	}

	public static Fire ok(String msg) {
		Fire fire = new Fire();
		fire.put("msg", msg);
		return fire;
	}
	
	public static Fire ok(Map<String, Object> map) {
		Fire fire = new Fire();
		fire.putAll(map);
		return fire;
	}
	
	public static Fire ok() {
		return new Fire();
	}

	@Override
	public Fire put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
