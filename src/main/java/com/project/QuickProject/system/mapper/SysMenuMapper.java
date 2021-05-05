package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据角色id获取menu 列表
     *
     * @param roleId 角色ids
     * @return R
     */
   List<SysMenu> listByRoleId(@Param("roleId") List<Integer> roleId);
//    @Select("SELECT b.* FROM sys_user_role a LEFT JOIN sys_role b ON a.role_id = b.id WHERE a.user_id = #{userId} AND  b.`status`=1")
//    List<SysMenu> listByRoleId(@Param("roleId") List<Integer> roleId);


//
//    @Select(" SELECT DISTINCT b.*FROM sys_role_menu a JOIN sys_menu b ON a.menu_id = b.id where a.role_id  = #{roleId} ORDER BY type,sort ASC")
//    List<SysMenu> listByRoleIds(@Param("roleId") Integer roleId);

}
