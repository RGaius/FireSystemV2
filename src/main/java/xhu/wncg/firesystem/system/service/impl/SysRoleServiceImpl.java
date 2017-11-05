package xhu.wncg.firesystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xhu.wncg.common.exception.FireException;
import xhu.wncg.common.utils.Constant;
import xhu.wncg.firesystem.system.mapper.SysRoleMapper;
import xhu.wncg.firesystem.system.pojo.SysRole;
import xhu.wncg.firesystem.system.service.SysRoleMenuService;
import xhu.wncg.firesystem.system.service.SysRoleService;
import xhu.wncg.firesystem.system.service.SysUserService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public SysRole queryObject(Long roleId) {
        return sysRoleMapper.queryObject(roleId);
    }

    @Override
    public List<SysRole> queryList(Map<String, Object> map) {
        return sysRoleMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysRoleMapper.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(SysRole role) {
        role.setCreateTime(new Date());
        sysRoleMapper.save(role);

        checkPrems(role);

        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

    }

    @Override
    public void update(SysRole role) {
        sysRoleMapper.update(role);

        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
    }

    @Override
    public void deleteBatch(Long[] roleIds) {
        sysRoleMapper.deleteBatch(roleIds);
    }

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return sysRoleMapper.queryRoleIdList(createUserId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRole role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            throw new FireException("新增角色的权限，已超出你的权限范围");
        }
    }
}
