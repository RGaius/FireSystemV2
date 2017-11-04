package xhu.wncg.firesystem.system.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xhu.wncg.common.annotation.SystemLog;
import xhu.wncg.common.utils.Constant;
import xhu.wncg.common.utils.Fire;
import xhu.wncg.common.utils.PageUtils;
import xhu.wncg.common.utils.Query;
import xhu.wncg.common.validator.Assert;
import xhu.wncg.common.validator.ValidatorUtils;
import xhu.wncg.common.validator.group.AddGroup;
import xhu.wncg.common.validator.group.UpdateGroup;
import xhu.wncg.firesystem.system.pojo.SysUser;
import xhu.wncg.firesystem.system.service.SysUserRoleService;
import xhu.wncg.firesystem.system.service.SysUserService;

import java.util.List;
import java.util.Map;

/**
 * @author BZhao
 * @version 2017/11/3.
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 获取用户列表
     *
     * @param params
     * @return
     */
    @PostMapping("/list")
    @RequiresPermissions("sys:user:list")
    public Fire list(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }

        //查询列表数据
        Query query = new Query(params);
        List<SysUser> userList = sysUserService.queryList(query);
        int total = sysUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
        return Fire.ok().put("page", pageUtil);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    @GetMapping("/info")
    public Fire info() {
        return Fire.ok().put("user", getUser());
    }

    /**
     * 修改登录密码
     *
     * @param password    密码
     * @param newPassword 新密码
     * @return
     */
    @SystemLog("修改密码")
    @PutMapping("/password")
    public Fire password(String password, String newPassword) {
        Assert.isBlank(newPassword, "新密码不为能空");

        //sha256加密
        password = new Sha256Hash(password, getUser().getSalt()).toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword, getUser().getSalt()).toHex();

        //更新密码
        int count = sysUserService.updatePassword(getUserId(), password, newPassword);
        if (count == 0) {
            return Fire.error("原密码不正确");
        }

        return Fire.ok();
    }

    /**
     * 通过用户id获取信息
     *
     * @param userId 用户id
     * @return object
     */
    @GetMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public Fire info(@PathVariable("userId") Long userId) {
        SysUser user = sysUserService.queryObject(userId);

        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        user.setRoleIdList(roleIdList);

        return Fire.ok().put("user", user);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @SystemLog("保存用户")
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public Fire save(@RequestBody SysUser user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.save(user);

        return Fire.ok();
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @SystemLog("修改用户")
    @PutMapping("/update")
    @RequiresPermissions("sys:user:update")
    public Fire update(@RequestBody SysUser user) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);

        user.setCreateUserId(getUserId());
        sysUserService.update(user);

        return Fire.ok();
    }

    /**
     * 删除用户
     *
     * @param userIds
     * @return
     */
    @SystemLog("删除用户")
    @DeleteMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public Fire delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return Fire.error("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return Fire.error("当前用户不能删除");
        }

        sysUserService.deleteBatch(userIds);

        return Fire.ok();
    }
}
