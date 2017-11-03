package xhu.wncg.firesystem.system.service.impl;

import org.springframework.stereotype.Service;
import xhu.wncg.firesystem.system.service.SysUserRoleService;

import java.util.List;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return null;
    }
}
