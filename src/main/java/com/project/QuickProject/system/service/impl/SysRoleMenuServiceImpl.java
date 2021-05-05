package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.system.entity.SysRoleMenu;
import com.project.QuickProject.system.mapper.SysRoleMenuMapper;
import com.project.QuickProject.system.service.ISysRoleMenuService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    /**
     * 根据roleId删除
     *
     * @param roleId 角色id
     */
    @Override
    public void deleteByRoleId(Integer roleId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.<SysRoleMenu>lambdaQuery()
                .eq(SysRoleMenu::getRoleId, roleId);
        this.remove(queryWrapper);
    }

    /**
     * 根据menuId删除
     *
     * @param menuId 菜单id
     */
    @Override
    public void deleteByMenuId(Integer menuId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.<SysRoleMenu>lambdaQuery()
                .eq(SysRoleMenu::getMenuId, menuId);
        this.remove(queryWrapper);
    }

    /**
     * 根据roleId获取menuIds
     *
     * @param roleId 角色id
     * @return R
     */
    @Override
    public List<Integer> getByRoleId(Integer roleId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = Wrappers.<SysRoleMenu>lambdaQuery()
                .eq(SysRoleMenu::getRoleId, roleId);
        List<SysRoleMenu> list = this.list(queryWrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        }
        return null;
    }
}
