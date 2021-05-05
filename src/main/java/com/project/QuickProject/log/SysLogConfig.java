package com.project.QuickProject.log;


import com.project.QuickProject.system.service.ISysLogService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Jimmey-Jiang
 * @date 2020-04-23 11:58 下午
 * @discription 日志配置类
 */
@EnableAsync
@AllArgsConstructor
@Configuration
@ConditionalOnWebApplication
public class SysLogConfig {

    private final ISysLogService sysLogService;

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener(sysLogService);
    }

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
