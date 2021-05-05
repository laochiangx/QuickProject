package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.dto.TenantDTO;
import com.project.QuickProject.system.entity.SysTenant;

import java.util.List;

/**
 * <p>
 * 租户信息表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysTenantService extends IService<SysTenant> {



    /**
     * 获取租户列表
     *
     * @param id 用户id
     * @return R
     */
    List<SysTenant> listByTenantId(Integer id);


    /**
     * 添加租户信息
     *
     * @param role 信息
     */
    void addTenant(TenantDTO role);

    /**
     * 更新租户信息
     *
     * @param role 信息
     * @return R
     */
    TenantDTO updateTenant(TenantDTO role);

    /**
     * 刪除租户
     *
     * @param tenantId 租户id
     */
    void delete(Integer tenantId);

    /**
     * 分页查询
     *
     * @param pageParams 参数
     * @return R
     */
    PageResult<List<SysTenant>> listPage(PageParams pageParams);

    /**
     * 根据id查找
     * @param tenantId 租户id
     * @return R
     */
    BaseResult<TenantDTO> selectById(Integer tenantId);

    /**
     * 更新状态
     * @param tenantId id
     * @param status Integer
     */
    void updateRoleStatus(Integer tenantId, Integer status);
}
