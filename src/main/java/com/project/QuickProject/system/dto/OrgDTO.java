package com.project.QuickProject.system.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@ApiModel(value = "添加角色信息")
public class OrgDTO implements Serializable {


    private static final long serialVersionUID = -2905980342499702064L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父节点id")
    private Integer orgPid;

    @ApiModelProperty(value = "所有的父节点")
    private String orgPids;

    @ApiModelProperty(value = "是否叶子节点")
    private Integer isLeaf;

    @ApiModelProperty(value = "组织机构名称")
    private String orgName;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "状态,1启用0无效")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;



}
