package com.project.QuickProject.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import  com.project.QuickProject.common.annotation.group.Default;
import  com.project.QuickProject.common.annotation.group.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Data
@ApiModel(value = "添加角色信息")
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -4882677300944973575L;

    @ApiModelProperty(value = "内部id")
    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名不能为空", groups = {Default.class, Update.class})
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "是否启用，默认1")
    private Boolean isEnable;

    @ApiModelProperty(value = "角色对应的菜单及权限")
    private List<Integer> menu;

}
