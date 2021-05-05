package com.project.QuickProject.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.project.QuickProject.system.vo.MenuTree;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Data
public class LoginUser implements UserDetails, Serializable {

    private static final long serialVersionUID = -5393788672041186399L;

    @ApiModelProperty(value = "主键，内部id")
    private Integer id;


    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
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
    private Integer isAdmin;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除,1已删0未删")
    private Integer delFlag;

    @ApiModelProperty(value = "租户id")
    private Integer tenantId;

    @ApiModelProperty(value = "最后一次更新的用户")
    private String updateuser;

    @ApiModelProperty(value = "最后一次登录id")
    private String lastloginip;

    @ApiModelProperty(value = "最后一次登录时间")
    private LocalDateTime lastlogintime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "角色信息")
    private Set<String> roles;

    @ApiModelProperty(value = "权限信息")
    private Set<String> permission;

    private List<MenuTree> topMenu = new ArrayList<>(0);

    private List<MenuTree> menu = new ArrayList<>(0);

    private String token;

    private CustomToken customToken;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        //设置角色
        if (CollectionUtils.isNotEmpty(roles)) {
            roles.forEach(role -> {
                if (role.startsWith("ROLE_")) {
                    collection.add(new SimpleGrantedAuthority(role));
                } else {
                    collection.add(new SimpleGrantedAuthority("ROLE_" + role));
                }
            });
        }
        //设置权限
        if (CollectionUtils.isNotEmpty(permission)) {
            permission.forEach(p -> {
                if (StringUtils.isNotBlank(p)) {
                    collection.add(new SimpleGrantedAuthority(p));
                }
            });
        }
        return collection;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {return true;}
}
