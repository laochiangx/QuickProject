package com.project.QuickProject.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
@ApiModel(value="SysLog对象", description="系统日志表")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "日志类型 1:用户日志 2菜单日志 3角色日志")
    private String type;

    @ApiModelProperty(value = "日志标题")
    private String title;

    @ApiModelProperty(value = "操作ip地址")
    private String ip;

    @ApiModelProperty(value = "操作地址")
    private String addr;

    @ApiModelProperty(value = "请求uri")
    @TableField("request_uri")
    private String requestUri;

    @ApiModelProperty(value = "请求方式(POST,GET,PUT,DELETE)")
    private String method;

    @ApiModelProperty(value = "请求提交参数")
    private String params;

    @ApiModelProperty(value = "请求时间")
    private Long time;

    @ApiModelProperty(value = "响应数据")
    private String response;

    @ApiModelProperty(value = "操作人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "是否删除,1已删0未删")
    @TableField("del_flag")
    private Integer delFlag;

    @ApiModelProperty(value = "租户id")
    @TableField("tenant_id")
    private Integer tenantId;


}
