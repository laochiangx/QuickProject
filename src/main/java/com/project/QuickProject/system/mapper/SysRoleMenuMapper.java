package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

}
