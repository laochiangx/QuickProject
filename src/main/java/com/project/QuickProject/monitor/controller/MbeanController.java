package com.project.QuickProject.monitor.controller;

import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.monitor.dto.BeanInfo;
import com.project.QuickProject.monitor.dto.Node;
import com.project.QuickProject.monitor.service.JmxService;
import com.project.QuickProject.monitor.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * MBeanController
 *
 * @author Jimmey-Jiang
 * @date 2020/7/15
 */
@Api(tags = "系统信息-JVM 信息")
@RestController
@RequestMapping(value = "bean")
public class MbeanController {

    @Autowired
    private JmxService jmxService;

    @GetMapping(value = "domains")
    public BaseResult<List<Node>> getDomains(){
        List<Node> domains = jmxService.getDomains();
        return BaseResult.success(domains);
    }

    @GetMapping(value = "properties")
    public BaseResult<BeanInfo> getPropertyList(String fullName){
        try {
            BeanInfo beanInfo = jmxService.getObjectNameProperties(fullName);
            return BaseResult.success(beanInfo);
        }catch (Exception e){
            return BaseResult.build(1,e.getMessage());
        }
    }

    @GetMapping(value = "run")
    public Result<Boolean> runMethod(String fullName,String methodName){
        try {
            jmxService.invokeMethod(fullName,methodName);
            return Result.success();
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }
}
