package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.system.entity.SysJob;
import com.project.QuickProject.system.mapper.SysJobMapper;
import com.project.QuickProject.system.service.ISysJobService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * quartz定时任务表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

}
