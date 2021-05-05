package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.dto.TenantDTO;
import com.project.QuickProject.system.dto.UserDTO;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.entity.SysTenant;
import com.project.QuickProject.system.entity.SysUser;
import com.project.QuickProject.system.mapper.SysRoleMapper;
import com.project.QuickProject.system.mapper.SysTenantMapper;
import com.project.QuickProject.system.service.ISysTenantService;
import com.project.QuickProject.system.service.ISysUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 租户信息表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements ISysTenantService {

    @Autowired
    private ISysTenantService sysTenantService;
    @Autowired
    private SysTenantMapper sysTenantMapper;

    @Override
    public List<SysTenant> listByTenantId(Integer id) {
        return sysTenantMapper.listByUserId(id);
    }

    @Override
    public void addTenant(TenantDTO tenant) {
        SysTenant entity = new SysTenant();
        BeanUtils.copyProperties(tenant, entity);
        this.save(entity);
    }

    @Override
    public TenantDTO updateTenant(TenantDTO Tenant) {
        SysTenant entity = new SysTenant();
        BeanUtils.copyProperties(Tenant, entity);
        this.updateById(entity);
        return Tenant;
    }

    @Override
    public void delete(Integer tenantId) {
        this.removeById(tenantId);
    }

    @Override
    public PageResult<List<SysTenant>> listPage(PageParams pageParams) {
        Page<SysTenant> page = pageParams.getIPage();
        LambdaQueryWrapper<SysTenant> queryWrapper = Wrappers.lambdaQuery();
        Page<SysTenant> result = this.page(page, queryWrapper);
        return PageResult.success(result.getRecords(), result.getTotal());
    }

    @Override
    public BaseResult<TenantDTO> selectById(Integer tenantId) {
        TenantDTO result = null;
        SysTenant userInfo = this.getById(tenantId);
        if (null != userInfo) {
            result = new TenantDTO();
            BeanUtils.copyProperties(userInfo, result);
        }
        return BaseResult.success(result);
    }

    @Override
    public void updateRoleStatus(Integer tenantId,Integer status) {
        SysTenant entity = new SysTenant();
        entity.setId(tenantId);
        entity.setDelFlag(Integer.toString(status));
        this.updateById(entity);
    }

}
