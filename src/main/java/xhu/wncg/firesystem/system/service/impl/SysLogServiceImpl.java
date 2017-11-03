package xhu.wncg.firesystem.system.service.impl;

import org.springframework.stereotype.Service;
import xhu.wncg.firesystem.system.pojo.SysConfig;
import xhu.wncg.firesystem.system.pojo.SysLog;
import xhu.wncg.firesystem.system.service.SysLogService;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/10/24.
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Override
    public SysLog queryObject(Long id) {
        return null;
    }

    @Override
    public List<SysLog> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysLog sysLog) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteBatch(Long[] ids) {

    }
}
