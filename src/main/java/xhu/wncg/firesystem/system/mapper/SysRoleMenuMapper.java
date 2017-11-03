package xhu.wncg.firesystem.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import xhu.wncg.common.mapper.BaseMapper;
import xhu.wncg.firesystem.system.pojo.SysRoleMenu;

import java.util.List;

/**
 * 角色与菜单对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:33:46
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu, SysRoleMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);
}
