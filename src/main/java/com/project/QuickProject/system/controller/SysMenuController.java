package com.project.QuickProject.system.controller;


import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.log.SysLog;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.service.ISysMenuService;
import com.project.QuickProject.system.vo.MenuTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    @ApiOperation(value = "添加菜单")
    @PreAuthorize("hasAnyAuthority('sys:menu:add')")
    @PostMapping
    @SysLog(value = "添加菜单", type = "2")
    public BaseResult<SysMenu> addRole(@Validated(Default.class) @RequestBody SysMenu menu) {
        return BaseResult.success(sysMenuService.addMenu(menu));
    }

    @ApiOperation(value = "更新菜单信息")
    @PreAuthorize("hasAnyAuthority('sys:menu:update')")
    @PutMapping
    @SysLog(value = "更新菜单信息", type = "2")
    public BaseResult<SysMenu> updateRole(@Validated(Update.class) @RequestBody SysMenu menu) {
        return BaseResult.success(sysMenuService.updateMenu(menu));
    }

    @ApiOperation(value = "刪除菜单")
    @PreAuthorize("hasAnyAuthority('sys:menu:del')")
    @SysLog(value = "刪除菜单", type = "2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "菜单id", paramType = "path")
    })
    @DeleteMapping("{menuId}")
    public BaseResult<String> deleteRole(@PathVariable Integer menuId) {
        sysMenuService.delete(menuId);
        return BaseResult.success();
    }

    @ApiOperation(value = "tree结构查询")
    @PreAuthorize("hasAnyAuthority('sys:menu:list','sys:menu:add','sys:menu:update','sys:menu:del')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mType", value = "布局类型，1：左侧菜单，2：顶部菜单", paramType = "query")
    })
    @GetMapping("/tree")
    public BaseResult<List<MenuTree>> listTreeAll(Integer mType) {
        return BaseResult.success(sysMenuService.listTreeAll(mType));
    }

    @ApiOperation(value = "简单结构查询")
    @PreAuthorize("hasAnyAuthority('sys:menu:list','sys:menu:add','sys:menu:update','sys:menu:del')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mType", value = "布局类型，1：左侧菜单，2：顶部菜单", paramType = "query")
    })
    @GetMapping
    public BaseResult<List<SysMenu>> listSimpleAll(Integer mType) {
        return BaseResult.success(sysMenuService.listSimpleAll(mType));
    }
}
