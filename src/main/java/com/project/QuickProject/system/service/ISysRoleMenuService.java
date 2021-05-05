package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.system.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 根据roleId删除
     * @param roleId 角色id
     */
    void deleteByRoleId(Integer roleId);

    /**
     * 根据menuId删除
     * @param menuId 菜单id
     */
    void deleteByMenuId(Integer menuId);

    /**
     * 根据roleId获取menuIds
     * @param roleId 角色id
     * @return R
     */
    List<Integer> getByRoleId(Integer roleId);
}
