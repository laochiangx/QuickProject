package com.project.QuickProject.system.controller;


import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.log.SysLog;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.dto.UserDTO;
import com.project.QuickProject.system.dto.UserQueryParams;
import com.project.QuickProject.system.service.ISysUserService;
import com.project.QuickProject.system.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/user")
public class SysUserController {


    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "添加用户")
    @PreAuthorize("hasAnyAuthority('sys:user:add')")
    @PostMapping
    @SysLog(value = "添加用户", type = "1")
    public BaseResult<String> addUser(@Validated(Default.class) @RequestBody UserDTO user) {
        sysUserService.addUser(user);
        return BaseResult.success();
    }

    @ApiOperation(value = "更新用户信息")
    @PreAuthorize("hasAnyAuthority('sys:user:update')")
    @PutMapping
    @SysLog(value = "更新用户信息", type = "1")
    public BaseResult<UserDTO> updateUser(@Validated(Update.class) @RequestBody UserDTO user) {
        return BaseResult.success(sysUserService.updateUser(user));
    }

    @ApiOperation(value = "更新状态")
    @PreAuthorize("hasAnyAuthority('sys:user:enable')")
    @PutMapping("{userId}/status/{status}")
    @SysLog(value = "更新状态", type = "1")
    public BaseResult<RoleDTO> updateRole(@PathVariable Integer userId, @PathVariable Integer status) {
        sysUserService.updateRoleStatus(userId, status);
        return BaseResult.success();
    }

    @ApiOperation(value = "刪除用户")
    @PreAuthorize("hasAnyAuthority('sys:user:del')")
    @DeleteMapping("{userId}")
    @SysLog(value = "刪除用户", type = "1")
    public BaseResult<RoleDTO> deleteUser(@PathVariable Integer userId) {
        sysUserService.delete(userId);
        return BaseResult.success();
    }

    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAnyAuthority('sys:user:list','sys:user:add','sys:user:update','sys:user:del','sys:user:enable')")
    @GetMapping
    public PageResult<List<SysUserVO>> listPage(UserQueryParams params) {
        return sysUserService.listPage(params);
    }

    @ApiOperation(value = "根据id查找")
    @PreAuthorize("hasAnyAuthority('sys:user:list','sys:user:add','sys:user:update','sys:user:del','sys:user:enable')")
    @GetMapping("{userId}")
    public BaseResult<UserDTO> selectById(@PathVariable Integer userId) {
        return sysUserService.selectById(userId);
    }

}
