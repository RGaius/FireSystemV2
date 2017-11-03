package xhu.wncg.firesystem.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xhu.wncg.common.annotation.SystemLog;
import xhu.wncg.common.utils.Constant;
import xhu.wncg.common.utils.Fire;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.validator.ValidatorUtils;
import xhu.wncg.firesystem.system.pojo.SysRole;
import xhu.wncg.firesystem.system.service.SysRoleMenuService;
import xhu.wncg.firesystem.system.service.SysRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月8日 下午2:18:33
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 角色列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public Fire list(@RequestParam Map<String, Object> params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysRole> list = sysRoleService.queryList(query);
        int total = sysRoleService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

        return Fire.ok().put("page", pageUtil);
    }

    /**
     * 角色列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public Fire select() {
        Map<String, Object> map = new HashMap<>();

        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("createUserId", getUserId());
        }
        List<SysRole> list = sysRoleService.queryList(map);

        return Fire.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public Fire info(@PathVariable("roleId") Long roleId) {
        SysRole role = sysRoleService.queryObject(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);

        return Fire.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SystemLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public Fire save(@RequestBody SysRole role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return Fire.ok();
    }

    /**
     * 修改角色
     */
    @SystemLog("修改角色")
    @PutMapping("/update")
    @RequiresPermissions("sys:role:update")
    public Fire update(@RequestBody SysRole role) {
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.update(role);

        return Fire.ok();
    }

    /**
     * 删除角色
     */
    @SystemLog("删除角色")
    @DeleteMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public Fire delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return Fire.ok();
    }
}
