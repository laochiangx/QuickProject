package com.project.QuickProject.monitor.controller;

import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.monitor.dto.Overview;
import com.project.QuickProject.monitor.service.MonitorDashboardService;
import com.project.QuickProject.monitor.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.management.ConnectorAddressLink;

/**
 * MonitorController
 *
 * @author Jimmey-Jiang
 * @date 2020/8/6
 */
@Api(tags = "系统信息-实时监控")
@RestController
@RequestMapping(value = "dashboard")
public class MonitorController {

    @Autowired
    private MonitorDashboardService monitorDashboardService;

    @GetMapping(value = "overview")
    public BaseResult<Overview> overview(){
        Overview overview = monitorDashboardService.overview();
        return BaseResult.success(overview);
    }

    @GetMapping(value = "abTest")
    public Result<String> abTest(){
        return Result.success("OK");
    }

}
