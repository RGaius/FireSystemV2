package xhu.wncg.firesystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhu.wncg.firesystem.system.mapper.SysLogMapper;
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
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLog queryObject(Long id) {
        return sysLogMapper.queryObject(id);
    }

    @Override
    public List<SysLog> queryList(Map<String, Object> map) {
        return sysLogMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysLogMapper.queryTotal(map);
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogMapper.save(sysLog);
    }

    @Override
    public void delete(Long id) {
        sysLogMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysLogMapper.deleteBatch(ids);
    }
}
