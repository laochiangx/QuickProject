package com.project.QuickProject.system.controller;


import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.log.SysLog;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/system/role")
public class SysRoleController {



    @Autowired
    private ISysRoleService sysRoleService;

    @ApiOperation(value = "添加角色")
    @PreAuthorize("hasAnyAuthority('sys:role:add')")
    @PostMapping
    @SysLog(value = "添加角色", type = "1")
    public BaseResult<String> addRole(@Validated(Default.class) @RequestBody RoleDTO role) {
        sysRoleService.addRole(role);
        return BaseResult.success();
    }

    @ApiOperation(value = "更新角色信息")
    @PreAuthorize("hasAnyAuthority('sys:role:update')")
    @PutMapping
    @SysLog(value = "更新角色信息", type = "1")
    public BaseResult<RoleDTO> updateRole(@Validated(Update.class) @RequestBody RoleDTO role) {
        return BaseResult.success(sysRoleService.updateRole(role));
    }

    @ApiOperation(value = "更新状态")
    @PreAuthorize("hasAnyAuthority('sys:role:enable')")
    @PutMapping("{roleId}/status/{enable}")
    @SysLog(value = "更新状态", type = "1")
    public BaseResult<RoleDTO> updateRole(@PathVariable Integer roleId, @PathVariable Boolean enable) {
        sysRoleService.updateRoleStatus(roleId, enable);
        return BaseResult.success();
    }

    @ApiOperation(value = "刪除角色")
    @PreAuthorize("hasAnyAuthority('sys:role:del')")
    @DeleteMapping("{roleId}")
    @SysLog(value = "刪除角色", type = "1")
    public BaseResult<RoleDTO> deleteRole(@PathVariable Integer roleId) {
        sysRoleService.delete(roleId);
        return BaseResult.success();
    }

    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAnyAuthority('sys:role:list','sys:role:add','sys:role:update','sys:role:del','sys:role:enable','sys:user:list')")
    @GetMapping
    public PageResult<List<SysRole>> listPage(PageParams pageParams) {
        return sysRoleService.listPage(pageParams);
    }

    @ApiOperation(value = "根据id查找")
    @PreAuthorize("hasAnyAuthority('sys:role:list','sys:role:add','sys:role:update','sys:role:del','sys:role:enable','sys:user:list')")
    @GetMapping("{roleId}")
    public BaseResult<RoleDTO> selectById(@PathVariable Integer roleId) {

        return sysRoleService.selectById(roleId);
    }

}
