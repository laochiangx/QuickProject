package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.system.dto.OrgDTO;
import com.project.QuickProject.system.dto.RoleDTO;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.entity.SysOrg;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.mapper.SysMenuMapper;
import com.project.QuickProject.system.mapper.SysOrgMapper;
import com.project.QuickProject.system.service.ISysOrgService;
import com.project.QuickProject.system.service.ISysOrgUserService;
import com.project.QuickProject.system.service.ISysRoleMenuService;
import com.project.QuickProject.system.vo.MenuTree;
import com.project.QuickProject.system.vo.SysOrgTree;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

    @Autowired
    private ISysOrgUserService sysOrgUserService;


    @Override
    public List<SysOrg> listByUserId(List<Integer> userId) {
        return sysOrgMapper.listByUserId(userId);
    }

    @Override
    public SysOrg addOrg(SysOrg org) {
        org.setId(null);
        this.save(org);
        return org;
    }

    @Override
    public SysOrg updateOrg(SysOrg org) {
        this.updateById(org);
        return org;
    }

    @Override
    public void delete(Integer orgId) {
        this.removeById(orgId);
        //sysOrgUserService.deleteByMenuId(orgId);
    }

    @Override
    public List<SysOrgTree> listTreeAll() {
        List<SysOrg> list = this.listSimpleAll();
        List<Integer> topIds = list.stream().filter(item -> item.getId() != 0).map(SysOrg::getId).collect(Collectors.toList());
        List<SysOrgTree> result = this.convertToTree(list, 0);
        return result;
    }

    /**
     * 转换成树形
     *
     * @param list 数据
     * @param pId  pid
     */
    private List<SysOrgTree> convertToTree(List<SysOrg> list, Integer pId) {
        List<SysOrgTree> result = new ArrayList<>();
        List<SysOrg> parent = list.stream().filter(item -> item.getOrgPid().equals(pId)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(parent)) {
            //获取children
            for (SysOrg org : parent) {
                SysOrgTree tempTree = new SysOrgTree();
                BeanUtils.copyProperties(org, tempTree);
                tempTree.setChildren(this.convertToTree(list, org.getId()));
                result.add(tempTree);
            }
        }
        return result;
    }
    @Override
    public List<SysOrg> listSimpleAll() {
        LambdaQueryWrapper<SysOrg> queryWrapper = Wrappers.<SysOrg>lambdaQuery();
        queryWrapper.orderByAsc().orderByAsc(SysOrg::getSort);
        return this.list(queryWrapper);
    }

    /**
     * 根据id查找
     *
     * @param userId 角色id
     * @return R
     */
    @Override
    public BaseResult<OrgDTO> selectById(Integer userId) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(userId);
        OrgDTO result = null;
        List<SysOrg> orgInfo = this.listByUserId(list);
        if (null != orgInfo) {
            result = new OrgDTO();
            BeanUtils.copyProperties(orgInfo.get(0), result);
        }
        return BaseResult.success(result);
    }

}
