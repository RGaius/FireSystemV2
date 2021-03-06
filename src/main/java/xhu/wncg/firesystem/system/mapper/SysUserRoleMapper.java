package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.common.mapper.BaseMapper;
import xhu.wncg.firesystem.system.pojo.SysUserRole;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:46
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole, SysUserRole> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);
}
