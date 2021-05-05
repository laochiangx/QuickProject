package com.project.QuickProject.system.dto;

import com.project.QuickProject.common.annotation.group.Default;
import com.project.QuickProject.common.annotation.group.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "添加、更新用户信息")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1171215105741391756L;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Integer id;

    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号", groups = Default.class)
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "角色")
    private List<Integer> role;

    @ApiModelProperty(value = "部门id")
    private Integer userOrgId;
}
