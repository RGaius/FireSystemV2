package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.common.mapper.BaseMapper;
import xhu.wncg.firesystem.system.pojo.SysUserToken;

/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserToken, SysUserToken> {
    /**
     * 通过用户id获取token
     *
     * @param userId
     * @return
     */
    SysUserToken queryByUserId(Long userId);

    /**
     * 查询用户token
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);
}
