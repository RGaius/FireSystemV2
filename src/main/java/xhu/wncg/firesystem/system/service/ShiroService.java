package xhu.wncg.firesystem.system.service;


import xhu.wncg.firesystem.system.pojo.SysUser;
import xhu.wncg.firesystem.system.pojo.SysUserToken;

import java.util.Set;

/**
 * shiro相关接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     */
    SysUser queryUser(Long userId);
}
