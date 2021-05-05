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
import java.time.LocalDateTime;

/**
 * @github:https://github.com/Jimmey-Jiang
 * @Author: Jimmey-Jiang
 * @E-mail:jimmey-jiang@foxmail.com
 * @Date: 2021/4/12 15:35
 **/
@Data
@ApiModel(value = "添加、更新租户信息")
public class TenantDTO  implements Serializable  {

    private static final long serialVersionUID = -5188748766477532095L;

    @ApiModelProperty(value = "主键id")
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "租户编号")
    private Integer tenantId;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;

    @ApiModelProperty(value = "备注信息")
    private String remark;


}
