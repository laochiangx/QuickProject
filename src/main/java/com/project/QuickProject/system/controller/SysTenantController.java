package com.project.QuickProject.system.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.log.SysLog;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.dto.TenantDTO;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.entity.SysTenant;
import com.project.QuickProject.system.service.ISysRoleService;
import com.project.QuickProject.system.service.ISysTenantService;
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
 * 租户信息表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "租户管理")
@RestController
@RequestMapping("/system/tenant")
public class SysTenantController {

    @Autowired
    private  ISysTenantService sysTenantService;


    @ApiOperation(value = "添加租户")
    @PreAuthorize("hasAnyAuthority('sys:tenant:add')")
    @PostMapping
    @SysLog(value = "添加租户", type = "1")
    public BaseResult<String> addTenant(@Validated(Default.class) @RequestBody TenantDTO tenant) {
        sysTenantService.addTenant(tenant);
        return BaseResult.success();
    }

    @ApiOperation(value = "更新租户信息")
    @PreAuthorize("hasAnyAuthority('sys:tenant:update')")
    @PutMapping
    @SysLog(value = "更新租信息", type = "1")
    public BaseResult<TenantDTO> updateTenant(@Validated(Update.class) @RequestBody TenantDTO tenant) {
        return BaseResult.success(sysTenantService.updateTenant(tenant));
    }

    @ApiOperation(value = "更新状态")
    @PreAuthorize("hasAnyAuthority('sys:tenant:enable')")
    @PutMapping("{tenantId}/status/{status}")
    @SysLog(value = "更新状态", type = "1")
    public BaseResult<SysTenant> updateTenant(@PathVariable Integer tenantId, @PathVariable Integer status) {
        sysTenantService.updateRoleStatus(tenantId, status);
        return BaseResult.success();
    }

    @ApiOperation(value = "刪除租户")
    @PreAuthorize("hasAnyAuthority('sys:tenant:del')")
    @DeleteMapping("{tenantId}")
    @SysLog(value = "刪除角色", type = "1")
    public BaseResult<SysTenant> deleteTenant(@PathVariable Integer tenantId) {
        sysTenantService.delete(tenantId);
        return BaseResult.success();
    }

    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAnyAuthority('sys:tenant:list','sys:tenant:add','sys:tenant:update','sys:tenant:del','sys:tenant:enable','sys:tenant:list')")
    @GetMapping
    public PageResult<List<SysTenant>> listPage(PageParams pageParams) {

        return sysTenantService.listPage(pageParams);
    }

    @ApiOperation(value = "根据id查找")
    @PreAuthorize("hasAnyAuthority('sys:tenant:list','sys:tenant:add','sys:tenant:update','sys:tenant:del','sys:tenant:enable','sys:tenant:list')")
    @GetMapping("{tenantId}")
    public BaseResult<TenantDTO> selectById(@PathVariable Integer tenantId) {
        return sysTenantService.selectById(tenantId);
    }


}
