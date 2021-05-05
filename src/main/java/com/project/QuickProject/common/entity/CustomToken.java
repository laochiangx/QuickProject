package com.project.QuickProject.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(description = "登录返回信息")
public class CustomToken implements Serializable {

    private static final long serialVersionUID = 7017542400082353692L;

    @ApiModelProperty(value = "登录的凭证，请求其他需要登录权限的接口时规则：请求头参数：Authorization，其值为：type + access_token")
    private String access_token;

    @ApiModelProperty(value = "登录时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date login_in;

    @ApiModelProperty(value = "凭证过期时间，用户进入app时间判断token过期前1天(不固定)可刷新的token")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date expires_in;

}
