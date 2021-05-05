package com.project.QuickProject.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.LoginUser;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.common.utils.Assert;
import com.project.QuickProject.system.dto.UserDTO;
import com.project.QuickProject.system.dto.UserQueryParams;
import com.project.QuickProject.system.entity.*;
import com.project.QuickProject.system.mapper.SysUserMapper;
import com.project.QuickProject.system.service.*;
import com.project.QuickProject.system.vo.MenuTree;
import com.project.QuickProject.system.vo.SysUserVO;
import com.project.QuickProject.system.vo.UserRoleVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Service
@Component
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {




    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper sysUserMapper;



    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysMenuService sysMenuService;

    @Autowired
    private ISysOrgUserService sysOrgUserService;

    /**
     * 根据账号获取信息
     *
     * @param username 账号
     * @return R
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginUser loadUserByUsername(String username) {
        SysUser info = this.getUserByUserName(username);
        if (null != info) {
            LoginUser loginUser = new LoginUser();
            BeanUtils.copyProperties(info, loginUser);
            //权限与角色
            List<SysRole> roleList = sysRoleService.listByUserId(info.getId());
            if (CollectionUtils.isNotEmpty(roleList)) {
                List<Integer> collect1 = roleList.stream().map(SysRole::getId).collect(Collectors.toList());
                List<SysMenu> menuList = sysMenuService.listByRoleId(collect1);
                if (CollectionUtils.isNotEmpty(menuList)) {
                    Set<String> collect = menuList.stream().map(SysMenu::getPermission).collect(Collectors.toSet());
                    loginUser.setPermission(collect);
                    //将顶部菜单与左侧菜单设置到缓存
                    List<SysMenu> leftMenu = menuList.stream().filter(item -> 1 == item.getMType())
                            .collect(Collectors.toList());
                    List<SysMenu> topMenu = menuList.stream().filter(item -> 2 == item.getMType())
                            .collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(leftMenu)) {
                        loginUser.setMenu(this.convertToTree(leftMenu, 0));
                    }
                    if (CollectionUtils.isNotEmpty(topMenu)) {
                        loginUser.setTopMenu(this.convertToTree(topMenu, 0));
                    }
                }
            }
            return loginUser;
        }
        return null;
    }

    public SysUser getUserByUserName(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUsername, username);
        return this.getOne(queryWrapper, false);
    }


    /**
     * 转换成树形
     *
     * @param list 数据
     * @param pId  pid
     */
    private List<MenuTree> convertToTree(List<SysMenu> list, Integer pId) {
        List<MenuTree> result = new ArrayList<>();
        List<SysMenu> parent = list.stream().filter(item -> item.getPId().equals(pId)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(parent)) {
            //获取children
            for (SysMenu menu : parent) {
                MenuTree tempTree = new MenuTree();
                BeanUtils.copyProperties(menu, tempTree);
                tempTree.setChildren(this.convertToTree(list, menu.getId()));
                result.add(tempTree);
            }
        }
        return result;
    }



    /**
     * 添加用户
     *
     * @param user 信息
     */
    @Override
    public void addUser(UserDTO user) {
        SysUser entity = new SysUser();
        BeanUtils.copyProperties(user, entity);
        //检查用户名
        SysUser exist = this.getUserByUserName(user.getUsername());
        Assert.isNull(exist, "用户名已经存在");
        if (StringUtils.isBlank(user.getPassword())) {
            entity.setPassword(UUID.randomUUID().toString());
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        if (StringUtils.isBlank(user.getNickname())) {
            entity.setNickname(user.getNickname());
        }
        this.save(entity);
        //保存用户-角色关联
        this.saveUserRole(entity.getId(), user.getRole());
        //保存用户-部门关联
        this.saveSysOrgUser(user.getId(),user.getUserOrgId());
    }

    /**
     * 更新用户信息
     *
     * @param user 信息
     * @return R
     */
    @Override
    public UserDTO updateUser(UserDTO user) {
        SysUser entity = new SysUser();
        entity.setId(user.getId());
        entity.setNickname(user.getNickname());
        if (StringUtils.isNotBlank(user.getPassword())) {
            entity.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        this.updateById(entity);
        //保存用户-角色关联
        sysUserRoleService.deleteByUserId(user.getId());
        this.saveUserRole(user.getId(), user.getRole());
        //保存用户-部门关联
        this.updateSysOrgUser(user.getId(),user.getUserOrgId());
        return user;
    }

    /**
     * 刪除用户
     *
     * @param userId 用户id
     */
    @Override
    public void delete(Integer userId) {
        this.checkSystem(userId);
        this.removeById(userId);
        sysUserRoleService.deleteByUserId(userId);
    }

    /**
     * 分页查询
     *
     * @param params 参数
     * @return R
     */
    @Override
    public PageResult<List<SysUserVO>> listPage(UserQueryParams params) {
        Page<SysUser> page = params.getIPage();
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(params.getNamePhone())) {
            queryWrapper.likeLeft(SysUser::getUsername, params.getNamePhone());
        }
        if (null != params.getIsEnable()) {
            queryWrapper.eq(SysUser::getStatus, params.getIsEnable());
        }
        Page<SysUser> pageResult = this.page(page, queryWrapper);
        List<SysUser> records = pageResult.getRecords();
        if (CollectionUtils.isNotEmpty(records)) {
            Map<Integer, List<UserRoleVO>> map = this.mapRoleByUserIds(records.stream().map(SysUser::getId)
                    .collect(Collectors.toList()));
            List<SysUserVO> collect = records.stream().map(item -> {
                SysUserVO sysUserVO = new SysUserVO();
                BeanUtils.copyProperties(item, sysUserVO);
                sysUserVO.setRoles(map.get(item.getId()));
                sysUserVO.setPassword("******");
                return sysUserVO;
            }).collect(Collectors.toList());
            return PageResult.success(collect, pageResult.getTotal());
        }
        return PageResult.success();
    }

    /**
     * 返回map结构
     *
     * @param userIds 用户ids
     * @return R
     */
    private Map<Integer, List<UserRoleVO>> mapRoleByUserIds(List<Integer> userIds) {
        List<UserRoleVO> list = sysUserMapper.listByUserIds(userIds);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.stream().collect(
                    Collectors.groupingBy(UserRoleVO::getUserId));
        }
        return new HashMap<>(0);
    }

    /**
     * 根据id查找
     *
     * @param userId 用户id
     * @return R
     */
    @Override
    public BaseResult<UserDTO> selectById(Integer userId) {
        UserDTO result = null;
        SysUser userInfo = this.getById(userId);
        if (null != userInfo) {
            result = new UserDTO();
            BeanUtils.copyProperties(userInfo, result);
            List<Integer> roleId = sysUserRoleService.getByRoleId(userId);
            result.setPassword("******");
            result.setRole(roleId);
        }
        return BaseResult.success(result);
    }

    /**
     * 更新状态
     *
     * @param userId 用户id
     * @param status boolean
     */
    @Override
    public void updateRoleStatus(Integer userId, Integer status) {
        SysUser entity = new SysUser();
        entity.setId(userId);
        entity.setStatus(status);
        this.updateById(entity);
    }


    /**
     * @param userId 用户id
     * @param roleId 角色ids
     */
    private void saveUserRole(Integer userId, List<Integer> roleId) {
        Integer tenantId=0;
        if (CollectionUtils.isNotEmpty(roleId)) {
            List<SysUserRole> list = roleId.stream().map(id -> new SysUserRole(0,userId, id,tenantId))
                    .collect(Collectors.toList());
            sysUserRoleService.saveBatch(list);
        }
    }



    /**
     * 检查是否是系统级别
     *
     * @param userId 系统用户id
     */
    private void checkSystem(Integer userId) {
        SysUser info = this.getById(userId);
        if (null != info) {
            Assert.isTrue(!"admin".equals(info.getUsername()), "系统级别，禁止操作");
        }
    }


    /**
     * @param userId 用户id
     * @param orgPid ids
     */
    private void saveSysOrgUser(Integer userId, Integer orgPid) {
        SysOrgUser entity = new SysOrgUser();
        entity.setOrgPid(orgPid);
        entity.setUserId(Integer.toString(userId));
        entity.setTenantId(1);
        sysOrgUserService.save(entity);
    }
    /**
     * @param userId 用户id
     * @param orgPid ids
     */
    private void updateSysOrgUser(Integer userId, Integer orgPid) {
        QueryWrapper<SysOrgUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .in("user_id", Integer.toString(userId));
        SysOrgUser entity =sysOrgUserService.getOne(queryWrapper);
        if (null != entity) {
            entity.setOrgPid(orgPid);
            sysOrgUserService.updateById(entity);
        }else{
        this.saveSysOrgUser(userId,orgPid);
        }

    }
}
