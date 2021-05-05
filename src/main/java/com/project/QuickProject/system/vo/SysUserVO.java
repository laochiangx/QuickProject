package com.project.QuickProject.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.project.QuickProject.system.entity.SysUser;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVO extends SysUser implements Serializable {

    private static final long serialVersionUID = 791914157994778956L;

    private List<UserRoleVO> roles;

}
