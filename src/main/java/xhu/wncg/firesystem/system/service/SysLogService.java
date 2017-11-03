package xhu.wncg.firesystem.system.service;


import xhu.wncg.firesystem.system.pojo.SysLog;

/**
 * @author BZhao
 * @version 2017/10/24.
 */
public interface SysLogService {
    /**
     * 保存系统日志
     * @param sysLog 日志
     */
    void save(SysLog sysLog);
}
