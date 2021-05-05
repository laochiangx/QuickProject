package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.entity.SysLog;
import com.project.QuickProject.system.entity.SysTenant;

import java.util.List;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysLogService extends IService<SysLog> {
    /**
     * 分页查询
     *
     * @param pageParams 参数
     * @return R
     */
    PageResult<List<SysLog>> listPage(PageParams pageParams);

}
