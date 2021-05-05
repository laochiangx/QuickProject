package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.vo.MenuTree;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据角色id获取menu 列表
     * @param roleId 角色ids
     * @return R
     */
    List<SysMenu> listByRoleId(List<Integer> roleId);

    /**
     * 添加菜单
     * @param menu 信息
     * @return R
     */
    SysMenu addMenu(SysMenu menu);

    /**
     * 更新菜单信息
     * @param menu 信息
     * @return R
     */
    SysMenu updateMenu(SysMenu menu);

    /**
     * 刪除菜单
     * @param menuId 菜单id
     */
    void delete(Integer menuId);

    /**
     * tree结构查询
     * @param mType 布局类型
     * @return R
     */
    List<MenuTree> listTreeAll(Integer mType);

    /**
     * 简单结构查询
     * @param mType 布局类型
     * @return R
     */
    List<SysMenu> listSimpleAll(Integer mType);
}
