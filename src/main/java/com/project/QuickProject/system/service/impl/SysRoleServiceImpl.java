package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.common.utils.Assert;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.entity.SysRoleMenu;
import com.project.QuickProject.system.mapper.SysRoleMapper;
import com.project.QuickProject.system.service.ISysRoleMenuService;
import com.project.QuickProject.system.service.ISysRoleService;
import com.project.QuickProject.system.service.ISysUserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {


    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;


    @Autowired
    private SysRoleMapper sysRoleMapper;
    /**
     * 根据用户id 获取角色列表
     *
     * @param userId 用户id
     * @return R
     */
    @Override
    public List<SysRole> listByUserId(Integer userId) {

        return sysRoleMapper.listByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(RoleDTO role) {
        SysRole entity = new SysRole();
        BeanUtils.copyProperties(role, entity);
        this.save(entity);
        //保存角色-菜单关联
        this.saveRoleMenu(entity.getId(), role.getMenu());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleDTO updateRole(RoleDTO role) {
        SysRole entity = new SysRole();
        BeanUtils.copyProperties(role, entity);
        this.updateById(entity);
        //删除-添加
        sysRoleMenuService.deleteByRoleId(entity.getId());
        //保存角色-菜单关联
        this.saveRoleMenu(role.getId(), role.getMenu());
        return role;
    }

    /**
     * 刪除角色
     *
     * @param roleId 角色id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer roleId) {
        this.checkSystem(roleId);
        sysRoleMenuService.deleteByRoleId(roleId);
        sysUserRoleService.deleteByRoleId(roleId);
        this.removeById(roleId);
    }


    /**
     * 分页查询
     *
     * @param pageParams 参数
     * @return R
     */
    @Override
    public PageResult<List<SysRole>> listPage(PageParams pageParams) {
        Page<SysRole> page = pageParams.getIPage();
        LambdaQueryWrapper<SysRole> queryWrapper = Wrappers.<SysRole>lambdaQuery();
        Page<SysRole> result = this.page(page, queryWrapper);
        return PageResult.success(result.getRecords(), result.getTotal());
    }

    /**
     * 根据id查找
     *
     * @param roleId 角色id
     * @return R
     */
    @Override
    public BaseResult<RoleDTO> selectById(Integer roleId) {
        RoleDTO result = null;
        SysRole roleInfo = this.getById(roleId);
        if (null != roleInfo) {
            result = new RoleDTO();
            BeanUtils.copyProperties(roleInfo, result);
            List<Integer> menuIds = sysRoleMenuService.getByRoleId(roleId);
            result.setMenu(menuIds);
        }
        return BaseResult.success(result);
    }

    /**
     * 更新状态
     *
     * @param roleId id
     * @param enable boolean
     */
    @Override
    public void updateRoleStatus(Integer roleId, Boolean enable) {
        this.checkSystem(roleId);
        SysRole entity = new SysRole();
        entity.setId(roleId);
        entity.setDelFlag(enable==true?1:0);
        this.updateById(entity);
    }

    /**
     * @param roleId 角色id
     * @param menuId 菜单ids
     */
    private void saveRoleMenu(Integer roleId, List<Integer> menuId) {
        if (CollectionUtils.isNotEmpty(menuId)) {
            List<SysRoleMenu> list = menuId.stream().map(id -> new SysRoleMenu(0,roleId, id,0))
                    .collect(Collectors.toList());
            sysRoleMenuService.saveBatch(list);
        }
    }

    /**
     * 检查是否是系统级别
     *
     * @param roleId 角色id
     */
    private void checkSystem(Integer roleId) {
        SysRole info = this.getById(roleId);
        if (null != info) {
            Assert.isTrue(info.getDelFlag()==0?true:false, "系统级别，禁止操作");
        }
    }



}
