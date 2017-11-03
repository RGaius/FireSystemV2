package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.firesystem.system.pojo.SysUser;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据用户名，查询系统用户
     * @param username 用户名
     * @return object
     */
    SysUser queryByUsername(String username);
}
