package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.PageParams;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 根据用户id 获取角色列表
     *
     * @param id 用户id
     * @return R
     */
    List<SysRole> listByUserId(Integer id);


    /**
     * 添加角色信息
     *
     * @param role 信息
     */
    void addRole(RoleDTO role);

    /**
     * 更新角色信息
     *
     * @param role 信息
     * @return R
     */
    RoleDTO updateRole(RoleDTO role);

    /**
     * 刪除角色
     *
     * @param roleId 角色id
     */
    void delete(Integer roleId);

    /**
     * 分页查询
     *
     * @param pageParams 参数
     * @return R
     */
    PageResult<List<SysRole>> listPage(PageParams pageParams);

    /**
     * 根据id查找
     * @param roleId 角色id
     * @return R
     */
    BaseResult<RoleDTO> selectById(Integer roleId);

    /**
     * 更新状态
     * @param roleId id
     * @param enable boolean
     */
    void updateRoleStatus(Integer roleId, Boolean enable);

}
