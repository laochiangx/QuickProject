package com.project.QuickProject.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户和角色关联表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_role")
@ApiModel(value="SysUserRole对象", description="用户和角色关联表")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Integer roleId;

    @ApiModelProperty(value = "租户id")
    @TableField("tenant_id")
    private Integer tenantId;


}
