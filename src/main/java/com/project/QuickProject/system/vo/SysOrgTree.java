package com.project.QuickProject.system.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.QuickProject.system.entity.SysMenu;
import com.project.QuickProject.system.entity.SysOrg;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @github:https://github.com/Jimmey-Jiang
 * @Author: Jimmey-Jiang
 * @E-mail:jimmey-jiang@foxmail.com
 * @Date: 2021/4/13 16:48
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysOrgTree extends SysOrg implements Serializable {


        private static final long serialVersionUID = 3373815541121367470L;

        private Boolean edit = false;

//        @JsonProperty("orgName")
//        private String oName;

        private List<com.project.QuickProject.system.vo.SysOrgTree> children;

}