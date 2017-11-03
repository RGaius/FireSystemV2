package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.firesystem.system.pojo.SysUserToken;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Mapper
public interface SysUserTokenMapper {
    /**
     * 通过用户id获取token
     * @param userId
     * @return
     */
    SysUserToken queryByUserId(Long userId);

    /**
     * 保存Token
     * @param token
     */
    void save(SysUserToken token);

    /**
     * 更新token
     * @param token
     */
    void update(SysUserToken token);
}
