package com.project.QuickProject.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.QuickProject.system.entity.SysOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 组织机构表 Mapper 接口
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrg> {

    List<SysOrg> listByUserId(@Param("userId") List<Integer> userId);

}
