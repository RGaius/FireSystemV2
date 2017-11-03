package xhu.wncg.firesystem.system.service;

import xhu.wncg.common.utils.Fire;
import xhu.wncg.firesystem.system.pojo.SysUserToken;


/**
 * @author BZhao
 * @version 2017/11/2.
 */
public interface SysUserTokenService {

    /**
     * 通过userId获取Token
     *
     * @param userId 用户id
     * @return token
     */
    SysUserToken queryByUserId(Long userId);

    /**
     * 保存token
     *
     * @param token
     */
    void save(SysUserToken token);

    /**
     * 更新token
     *
     * @param token
     */
    void update(SysUserToken token);

    /**
     * 创建Token
     *
     * @param userId userId
     * @return map
     */
    Fire createToken(Long userId);

    /**
     * 退出登录
     *
     * @param userId 用户Id
     */
    void logout(Long userId);
}
