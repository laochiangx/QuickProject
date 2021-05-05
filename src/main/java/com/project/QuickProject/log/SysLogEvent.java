package com.project.QuickProject.log;

import org.springframework.context.ApplicationEvent;

/**
 * @author Jimmey-Jiang
 * @date 2020-04-23 5:46 下午
 * @discription 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(Object source) {
        super(source);
    }
}
