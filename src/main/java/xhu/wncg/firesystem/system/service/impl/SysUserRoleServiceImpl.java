package xhu.wncg.firesystem.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhu.wncg.firesystem.system.mapper.SysUserMapper;
import xhu.wncg.firesystem.system.mapper.SysUserRoleMapper;
import xhu.wncg.firesystem.system.service.SysUserRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if(roleIdList.size() == 0){
            return ;
        }

        //先删除用户与角色关系
        sysUserRoleMapper.delete(userId);

        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleMapper.save(map);
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleMapper.queryRoleIdList(userId);
    }

}
