package xhu.wncg.firesystem.system.service;

import xhu.wncg.common.utils.Query;
import xhu.wncg.firesystem.system.pojo.SysUser;

import java.util.List;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
public interface SysUserService {

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 获取sysUser对象
     *
     * @param username
     * @return object
     */
    SysUser queryByUsername(String username);

    /**
     * 获取系统用户列表
     *
     * @param query 参数
     * @return list
     */
    List<SysUser> queryList(Query query);

    /**
     * 获取查询数据的条数
     *
     * @param query 参数
     * @return int
     */
    int queryTotal(Query query);

    /**
     * 更新密码
     *
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    int updatePassword(Long userId, String password, String newPassword);

    /**
     * 通过用户id查询用户
     *
     * @param userId 用户id
     * @return object
     */
    SysUser queryObject(Long userId);

    /**
     * 保存用户
     *
     * @param user
     */
    void save(SysUser user);

    /**
     * 更新用户
     *
     * @param user
     */
    void update(SysUser user);

    /**
     * 批量删除用户
     *
     * @param userIds
     */
    void deleteBatch(Long[] userIds);
}
