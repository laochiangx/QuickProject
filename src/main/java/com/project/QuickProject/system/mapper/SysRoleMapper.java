package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户id 获取角色列表
     *
     * @param userId 用户id
     * @return R
     */
    @Select("SELECT b.* FROM sys_user_role a LEFT JOIN sys_role b ON a.role_id = b.id WHERE a.user_id = #{userId} AND  b.`status`=1")
    List<SysRole> listByUserId(@Param("userId") Integer userId);

//    List<SysRole> listByUserId(Integer userId);
}
