package xhu.wncg.firesystem.system.service;

import xhu.wncg.firesystem.system.pojo.SysRole;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
public interface SysRoleService {
    /**
     * @param roleId
     * @return
     */
    SysRole queryObject(Long roleId);

    /**
     * @param map
     * @return
     */
    List<SysRole> queryList(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * @param role
     */
    void save(SysRole role);

    /**
     * @param role
     */
    void update(SysRole role);

    /**
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
