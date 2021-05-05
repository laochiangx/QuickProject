package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.entity.SysLog;
import com.project.QuickProject.system.entity.SysTenant;
import com.project.QuickProject.system.mapper.SysLogMapper;
import com.project.QuickProject.system.service.ISysLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {


    @Override
    public PageResult<List<SysLog>> listPage(PageParams pageParams) {
        Page<SysLog> Logpage = pageParams.getIPage();
        LambdaQueryWrapper<SysLog> LogqueryWrapper = Wrappers.lambdaQuery();
        //Page<SysLog> result = this.page(Logpage, LogqueryWrapper);
        QueryWrapper<SysLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(SysLog::getCreateTime);
        Page<SysLog> result = this.page(Logpage, queryWrapper);
        return PageResult.success(result.getRecords(), result.getTotal());
    }


}
