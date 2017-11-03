package xhu.wncg.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xhu.wncg.common.utils.Fire;

/**
 * 异常处理器
 * @author BZhao
 * @version 2017/10/24.
 */
@RestControllerAdvice
public class FireExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(FireException.class)
    public Fire handleFireException(FireException e){
        Fire fire = new Fire();
        fire.put("code", e.getCode());
        fire.put("msg", e.getMessage());
        return fire;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Fire handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return Fire.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public Fire handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return Fire.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public Fire handleException(Exception e){
        logger.error(e.getMessage(), e);
        return Fire.error();
    }
}
