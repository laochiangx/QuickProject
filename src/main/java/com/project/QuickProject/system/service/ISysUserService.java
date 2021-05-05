package com.project.QuickProject.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.QuickProject.common.entity.BaseResult;
import com.project.QuickProject.common.entity.LoginUser;
import com.project.QuickProject.common.entity.PageResult;
import com.project.QuickProject.system.dto.UserDTO;
import com.project.QuickProject.system.dto.UserQueryParams;
import com.project.QuickProject.system.entity.SysUser;
import com.project.QuickProject.system.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据账号获取信息
     * @param username 账号
     * @return R
     */
    LoginUser loadUserByUsername(String username);


    /**
     * 添加用户
     * @param user 信息
     */
    void addUser(UserDTO user);

    /**
     * 更新用户信息
     * @param user 信息
     * @return R
     */
    UserDTO updateUser(UserDTO user);

    /**
     * 刪除用户
     * @param userId 用户id
     */
    void delete(Integer userId);

    /**
     * 分页查询
     * @param params 参数
     * @return R
     */
    PageResult<List<SysUserVO>> listPage(UserQueryParams params);

    /**
     * 根据id查找
     * @param userId 用户id
     * @return R
     */
    BaseResult<UserDTO> selectById(Integer userId);

    /**
     * 更新状态
     * @param userId 用户id
     * @param status Integer
     */
    void updateRoleStatus(Integer userId, Integer status);
}
