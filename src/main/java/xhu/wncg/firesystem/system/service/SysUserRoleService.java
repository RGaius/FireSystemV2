package xhu.wncg.firesystem.system.service;

import java.util.List;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
public interface SysUserRoleService {
    /**
     * 查询用户权限
     *
     * @param userId 用户id
     * @return
     */
    List<Long> queryRoleIdList(Long userId);

    /**
     *
     * @param userId
     * @param roleIdList
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);
}
