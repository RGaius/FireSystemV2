package xhu.wncg.firesystem.system.service;


import xhu.wncg.firesystem.system.pojo.SysLog;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/10/24.
 */
public interface SysLogService {
    /**
     * 查询对象
     * @param id
     * @return
     */
    SysLog queryObject(Long id);

    /**
     * 查询列表
     * @param map
     * @return
     */
    List<SysLog> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 更新
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteBatch(Long[] ids);
}
