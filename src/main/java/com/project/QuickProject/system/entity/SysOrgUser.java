package com.project.QuickProject.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_org_user")
@ApiModel(value="SysOrgUser对象", description="组织机构表")
public class SysOrgUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父节点id")
    @TableField("org_pid")
    private Integer orgPid;

    @ApiModelProperty(value = "所有的父节点")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "租户id")
    @TableField("tenant_id")
    private Integer tenantId;


}
