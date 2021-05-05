package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.system.entity.SysUserRole;
import com.project.QuickProject.system.mapper.SysUserRoleMapper;
import com.project.QuickProject.system.service.ISysUserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    /**
     * 根据用户id删除关联
     *
     * @param userId 用户id
     */
    @Override
    public void deleteByUserId(Integer userId) {
        LambdaQueryWrapper<SysUserRole> queryWrapper = Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, userId);
        this.remove(queryWrapper);
    }

    /**
     * 根据userId获取roleIds
     *
     * @param userId 用户id
     * @return R
     */
    @Override
    public List<Integer> getByRoleId(Integer userId) {
        LambdaQueryWrapper<SysUserRole> queryWrapper = Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, userId);
        List<SysUserRole> list = this.list(queryWrapper);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 根据角色id删除关联
     *
     * @param roleId 角色id
     */
    @Override
    public void deleteByRoleId(Integer roleId) {
        LambdaQueryWrapper<SysUserRole> queryWrapper = Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getRoleId, roleId);
        this.remove(queryWrapper);
    }
}
