package com.project.QuickProject.system.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserRoleVO implements Serializable {

    private static final long serialVersionUID = -2376040060794014064L;

    private Integer userId;

    private Integer roleId;

    private String roleName;
}
