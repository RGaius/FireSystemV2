package xhu.wncg.firesystem.system.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhu.wncg.common.utils.Constant;
import xhu.wncg.firesystem.system.mapper.SysMenuMapper;
import xhu.wncg.firesystem.system.mapper.SysUserMapper;
import xhu.wncg.firesystem.system.mapper.SysUserTokenMapper;
import xhu.wncg.firesystem.system.pojo.SysMenu;
import xhu.wncg.firesystem.system.pojo.SysUser;
import xhu.wncg.firesystem.system.pojo.SysUserToken;
import xhu.wncg.firesystem.system.service.ShiroService;

import java.util.*;

@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenu> menuList = sysMenuMapper.queryList(new HashMap<>());
            permsList = new ArrayList<>(menuList.size());
            for (SysMenu menu : menuList) {
                permsList.add(menu.getPerms());
            }
        } else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return sysUserMapper.queryObject(userId);
    }
}
