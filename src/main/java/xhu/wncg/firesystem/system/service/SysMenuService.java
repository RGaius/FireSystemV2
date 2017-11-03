package xhu.wncg.firesystem.system.service;


import xhu.wncg.firesystem.system.pojo.SysMenu;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 * @author BZhao
 */
public interface SysMenuService {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     * @return list
     */
    List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @return list
     */
    List<SysMenu> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     * @return list
     */
    List<SysMenu> queryNotButtonList();

    /**
     * 获取用户菜单列表
     * @param userId 用户id
     * @return list
     */
    List<SysMenu> getUserMenuList(Long userId);

    /**
     * 查询菜单
     * @param menuId 菜单id
     * @return object
     */
    SysMenu queryObject(Long menuId);

    /**
     * 查询菜单列表
     * @param map map
     * @return list
     */
    List<SysMenu> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @param map
     * @return int
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存菜单
     * @param menu
     */
    void save(SysMenu menu);

    /**
     * 修改
     *
     * @param menu
     */
    void update(SysMenu menu);

    /**
     * 删除
     *
     * @param menuIds
     */
    void deleteBatch(Long[] menuIds);

    /**
     * 查询用户的权限列表
     * @param userId
     * @return list
     */
    List<SysMenu> queryUserList(Long userId);
}
