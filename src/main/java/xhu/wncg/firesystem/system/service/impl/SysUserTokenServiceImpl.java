package xhu.wncg.firesystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhu.wncg.common.utils.Fire;
import xhu.wncg.firesystem.system.mapper.SysUserTokenMapper;
import xhu.wncg.firesystem.system.oauth2.TokenGenerator;
import xhu.wncg.firesystem.system.pojo.SysUserToken;
import xhu.wncg.firesystem.system.service.SysUserTokenService;

import java.util.Date;


/**
 * @author BZhao
 * @version 2017/11/2.
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {
    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    //24小时后过期
    private final static int EXPIRE = 3600 * 24;

    @Override
    public SysUserToken queryByUserId(Long userId) {
        return sysUserTokenMapper.queryByUserId(userId);
    }

    @Override
    public void save(SysUserToken token) {
        sysUserTokenMapper.save(token);
    }

    @Override
    public void update(SysUserToken token) {
        sysUserTokenMapper.update(token);
    }

    @Override
    public Fire createToken(Long userId) {
        //生成Token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        SysUserToken tokenEntity = queryByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            update(tokenEntity);
        }
        return Fire.ok().put("token", token).put("expire", EXPIRE);
    }

    @Override
    public void logout(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserToken tokenEntity = new SysUserToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        update(tokenEntity);
    }
}
