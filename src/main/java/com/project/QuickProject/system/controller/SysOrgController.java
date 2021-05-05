package com.project.QuickProject.system.controller;


import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.log.SysLog;
import com.project.QuickProject.system.dto.OrgDTO;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.entity.SysOrg;
import com.project.QuickProject.system.service.ISysMenuService;
import com.project.QuickProject.system.service.ISysOrgService;
import com.project.QuickProject.system.vo.MenuTree;
import com.project.QuickProject.system.vo.SysOrgTree;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("/system/org")
public class SysOrgController {

    @Autowired
    private ISysOrgService sysOrgService;

    @ApiOperation(value = "添加部门")
    @PreAuthorize("hasAnyAuthority('sys:org:add')")
    @PostMapping
    @SysLog(value = "添加部门", type = "1")
    public BaseResult<SysOrg> addRole(@Validated(Default.class) @RequestBody SysOrg org) {
        return BaseResult.success(sysOrgService.addOrg(org));
    }

    @ApiOperation(value = "更新部门信息")
    @PreAuthorize("hasAnyAuthority('sys:org:update')")
    @PutMapping
    @SysLog(value = "更新部门信息", type = "1")
    public BaseResult<SysOrg> updateRole(@Validated(Update.class) @RequestBody SysOrg org) {
        return BaseResult.success(sysOrgService.updateOrg(org));
    }

    @ApiOperation(value = "刪除部门")
    @PreAuthorize("hasAnyAuthority('sys:org:del')")
    @SysLog(value = "刪除部门", type = "1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId", value = "部门id", paramType = "path")
    })
    @DeleteMapping("{orgId}")
    public BaseResult<String> deleteRole(@PathVariable Integer orgId) {
        sysOrgService.delete(orgId);
        return BaseResult.success();
    }

    @ApiOperation(value = "tree结构查询")
    @PreAuthorize("hasAnyAuthority('sys:org:list','sys:org:add','sys:org:update','sys:org:del')")
    @GetMapping("/tree")
    public BaseResult<List<SysOrgTree>> listTreeAll() {
        return BaseResult.success(sysOrgService.listTreeAll());
    }

    @ApiOperation(value = "简单结构查询")
    @PreAuthorize("hasAnyAuthority('sys:org:list','sys:org:add','sys:org:update','sys:org:del')")
    @GetMapping
    public BaseResult<List<SysOrg>> listSimpleAll() {
        return BaseResult.success(sysOrgService.listSimpleAll());
    }




    @ApiOperation(value = "根据用户id查询所在部门")
    @PreAuthorize("hasAnyAuthority('sys:org:list')")
    @SysLog(value = "根据用户id查询所在部门", type = "1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", paramType = "path")
    })
    @GetMapping("/listByUserId/{userId}")
    public BaseResult<List<SysOrg>>  listByUserId(@PathVariable Integer userId) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(userId);
        return BaseResult.success(sysOrgService.listByUserId(list));
    }

    @ApiOperation(value = "根据id查找")
    @PreAuthorize("hasAnyAuthority('sys:org:list','sys:org:add','sys:org:update','sys:org:del','sys:org:enable','sys:org:list')")
    @GetMapping("{userId}")
    public  BaseResult<OrgDTO> selectById(@PathVariable Integer userId) {
        return sysOrgService.selectById(userId);
    }

}
