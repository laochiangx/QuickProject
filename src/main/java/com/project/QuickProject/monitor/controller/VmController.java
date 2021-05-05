package com.project.QuickProject.monitor.controller;

import com.project.QuickProject.monitor.dto.Vm;
import com.project.QuickProject.monitor.service.VmService;
import com.project.QuickProject.monitor.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * VmController
 *
 * @author Jimmey-Jiang
 * @date 2020/8/27
 */
@Api(tags = "系统信息-cpu明细")
@RestController
@RequestMapping(value = "vm")
public class VmController {

    @Autowired
    private VmService vmService;

    @GetMapping(value = "localJvms")
    public Result<List<Vm>> getLocalJvmProcessList(){
        try {
            List<Vm> jvms = vmService.getLocalJvm();
            return Result.success(jvms);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping(value = "attachLocalJvm")
    public Result<Boolean> attachLocalJvm(Integer pid){
        try {
            List<Vm> jvms = vmService.getLocalJvm();
            for (int i=0;i<jvms.size();i++)
            {
                if (jvms.get(i).getName().equals("com.project.QuickProject.QuickProjectApplication"))
                {
                    vmService.attachJvm(jvms.get(i).getPid());
                }
            }
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping(value = "attachRemoteJvm")
    public Result<Boolean> attachRemoteJvm(String host,String port){
        try {
            vmService.attachRemoteJvm(host,port);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
