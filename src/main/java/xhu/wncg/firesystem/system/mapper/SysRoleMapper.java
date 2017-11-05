package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.common.mapper.BaseMapper;
import xhu.wncg.firesystem.system.pojo.SysRole;

import java.util.List;

/**
 * 角色管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:33
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole, SysRole> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);
}
