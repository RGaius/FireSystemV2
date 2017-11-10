package xhu.wncg.firesystem.system.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xhu.wncg.firesystem.system.pojo.SysUser;


/**
 * Controller 公共组件
 *
 * @author BZhao
 * @version 2017/11/2.
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
