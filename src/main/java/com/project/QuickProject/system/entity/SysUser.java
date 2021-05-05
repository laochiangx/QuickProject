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
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "状态,1可用0不可用")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否是系统管理员")
    @TableField("is_admin")
    private Integer isAdmin;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除,1已删0未删")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "租户id")
    @TableField("tenant_id")
    private Integer tenantId;

    @ApiModelProperty(value = "最后一次更新的用户")
    @TableField("update_user")
    private String updateuser;

    @ApiModelProperty(value = "最后一次登录id")
    @TableField("last_login_ip")
    private String lastloginip;

    @ApiModelProperty(value = "最后一次登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastlogintime;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;
}
