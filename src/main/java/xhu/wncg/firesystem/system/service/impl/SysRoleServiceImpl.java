package xhu.wncg.firesystem.system.service.impl;

import org.springframework.stereotype.Service;
import xhu.wncg.firesystem.system.pojo.SysRole;
import xhu.wncg.firesystem.system.service.SysRoleService;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Override
    public SysRole queryObject(Long roleId) {
        return null;
    }

    @Override
    public List<SysRole> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(SysRole role) {

    }

    @Override
    public void update(SysRole role) {

    }

    @Override
    public void deleteBatch(Long[] roleIds) {

    }

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return null;
    }
}
