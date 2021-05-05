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
import java.util.Date;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_org")
@ApiModel(value="SysOrg对象", description="组织机构表")
public class SysOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父节点id")
    @TableField("org_pid")
    private Integer orgPid;

    @ApiModelProperty(value = "所有的父节点")
    @TableField("org_pids")
    private String orgPids;

    @ApiModelProperty(value = "是否叶子节点")
    @TableField("is_leaf")
    private Integer isLeaf;

    @ApiModelProperty(value = "组织机构名称")
    @TableField("org_name")
    private String orgName;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "状态,1启用0无效")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "菜单的层级")
    private Integer level;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除,1已删0未删")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "租户id")
    @TableField("tenant_id")
    private Integer tenantId;


}
