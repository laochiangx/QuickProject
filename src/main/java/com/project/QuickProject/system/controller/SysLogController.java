package com.project.QuickProject.system.controller;


import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.entity.SysLog;
import com.project.QuickProject.system.entity.SysTenant;
import com.project.QuickProject.system.service.ISysLogService;
import com.project.QuickProject.system.service.ISysTenantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Api(tags = "日志管理")
@RestController
@RequestMapping("/system/log")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAnyAuthority('sys:log:list','sys:log:del','sys:jvm:list')")
    @GetMapping
    public PageResult<List<SysLog>> listPage(PageParams pageParams) {
        return sysLogService.listPage(pageParams);
    }

}
