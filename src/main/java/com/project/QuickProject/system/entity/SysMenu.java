package com.project.QuickProject.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "系统-菜单")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "menu id")
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(message = "菜单id不能为空", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    @NotBlank(message = "标题不能为空", groups = {Default.class, Update.class})
    private String title;

    @ApiModelProperty(value = "唯一，找路由使用")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限标识")
    @TableField("permission")
    private String permission;

    @ApiModelProperty(value = "父类id，默认0（第一级）")
    @TableField("p_id")
    @JsonProperty("pId")
    private Integer pId;

    @ApiModelProperty(value = "顶部id")
    @TableField("t_id")
    @JsonProperty("tId")
    private Integer tId;

    @ApiModelProperty(value = "1：菜单，2：按钮")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "1：左侧菜单，2：顶部菜单")
    @TableField("m_type")
    @JsonProperty("mType")
    private Integer mType;

    @ApiModelProperty(value = "路径，一级加/，其他不要加/")
    @TableField("path")
    private String path;

    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

}
