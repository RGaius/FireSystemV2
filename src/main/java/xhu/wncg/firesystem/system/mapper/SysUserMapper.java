package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.common.mapper.BaseMapper;
import xhu.wncg.firesystem.system.pojo.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser, SysUser> {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param username 用户名
     * @return object
     */
    SysUser queryByUsername(String username);

    /**
     * 修改密码
     */
    int updatePassword(Map<String, Object> map);
}
