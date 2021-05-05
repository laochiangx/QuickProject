package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.system.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysUserRoleService extends IService<SysUserRole> {
    /**
     * 根据用户id删除关联
     *
     * @param userId 用户id
     */
    void deleteByUserId(Integer userId);

    /**
     * 根据userId获取roleIds
     *
     * @param userId 用户id
     * @return R
     */
    List<Integer> getByRoleId(Integer userId);

    /**
     * 根据角色id删除关联
     * @param roleId 角色id
     */
    void deleteByRoleId(Integer roleId);

}
