package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.system.dto.OrgDTO;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.entity.SysOrg;
import com.project.QuickProject.system.vo.MenuTree;
import com.project.QuickProject.system.vo.SysOrgTree;

import java.util.List;

/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysOrgService extends IService<SysOrg> {

    /**
     * 根据用户 id获取部门列表
     * @param userId 用户ids
     * @return R
     */
    List<SysOrg> listByUserId(List<Integer> userId);

    /**
     * 添加部门
     * @param org 信息
     * @return R
     */
    SysOrg addOrg(SysOrg org);

    /**
     * 更新部门信息
     * @param org 信息
     * @return R
     */
    SysOrg updateOrg(SysOrg org);

    /**
     * 刪除部门
     * @param orgId 菜单id
     */
    void delete(Integer orgId);

    /**
     * tree结构查询
     * @param
     * @return R
     */
    List<SysOrgTree> listTreeAll();

    /**
     * 简单结构查询
     * @param
     * @return R
     */
    List<SysOrg> listSimpleAll();

    /**
     * 根据id查找
     * @param userId 用户id
     * @return R
     */
    BaseResult<OrgDTO> selectById(Integer userId);

}
