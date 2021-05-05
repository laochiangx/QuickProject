package com.project.QuickProject.log;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.QuickProject.common.utils.SpringContextHolder;
import com.project.QuickProject.common.utils.SysLogUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Jimmey-Jiang
 * @date 2020-04-23 5:20 下午
 * @discription 系统日志切面类
 */
@Aspect
@Slf4j
public class SysLogAspect {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, SysLog sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        com.project.QuickProject.system.entity.SysLog logVo = SysLogUtils.getSysLog();
        logVo.setTitle(sysLog.value());
        logVo.setType(sysLog.type());
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        //接口响应数据
        Object obj = point.proceed();
        Long endTime = System.currentTimeMillis();
        logVo.setTime(endTime - startTime);
        logVo.setResponse(objectMapper.writeValueAsString(obj));
        SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        return obj;
    }

}

