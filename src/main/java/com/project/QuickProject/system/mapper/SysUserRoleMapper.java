package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
