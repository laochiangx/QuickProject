package com.project.QuickProject.log;


import com.project.QuickProject.system.service.ISysLogService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author Jimmey-Jiang
 * @date 2020-04-23 11:51 下午
 * @discription 系统日志事件监听器（只要上下文发送事件，就会被监听到）
 */
@AllArgsConstructor
public class SysLogListener {

    private final ISysLogService sysLogService;

    /**
     * 监听到系统日志事件就执行保存
     *
     * @param sysLogEvent
     * @return void
     */
    @Async
    @EventListener(SysLogEvent.class)
    public void eventListen(SysLogEvent sysLogEvent) {
        com.project.QuickProject.system.entity.SysLog sysLog = (com.project.QuickProject.system.entity.SysLog) sysLogEvent.getSource();
        sysLogService.save(sysLog);
    }
}
