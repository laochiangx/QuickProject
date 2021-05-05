package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysUser;
import com.project.QuickProject.system.vo.UserRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据用户查询角色信息
     * @param userIds 用户ids
     * @return R
     */
    List<UserRoleVO> listByUserIds(@Param("userIds") List<Integer> userIds);
}
