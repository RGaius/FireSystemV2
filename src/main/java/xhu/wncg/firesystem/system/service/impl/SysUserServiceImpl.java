package xhu.wncg.firesystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhu.wncg.common.utils.Query;
import xhu.wncg.firesystem.system.mapper.SysUserMapper;
import xhu.wncg.firesystem.system.pojo.SysUser;
import xhu.wncg.firesystem.system.service.SysRoleService;
import xhu.wncg.firesystem.system.service.SysUserRoleService;
import xhu.wncg.firesystem.system.service.SysUserService;

import java.util.List;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;
    @Override
    public SysUser queryByUsername(String username) {
        return sysUserMapper.queryByUsername(username);
    }

    @Override
    public List<SysUser> queryList(Query query) {
        return null;
    }

    @Override
    public int queryTotal(Query query) {
        return 0;
    }

    @Override
    public int updatePassword(Long userId, String password, String newPassword) {
        return 0;
    }

    @Override
    public SysUser queryObject(Long userId) {
        return null;
    }

    @Override
    public void save(SysUser user) {

    }

    @Override
    public void update(SysUser user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }
}
