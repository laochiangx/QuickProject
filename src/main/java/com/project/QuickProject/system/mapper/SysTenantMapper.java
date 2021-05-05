package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysRole;
import com.project.QuickProject.system.entity.SysTenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 租户信息表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysTenantMapper extends BaseMapper<SysTenant> {


    @Select("select *from sys_tenant where id = #{id} AND  del_flag=0")
    List<SysTenant> listByUserId(@Param("id") Integer id);

}
