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
 * quartz定时任务表
 * </p>
 *
 * @author jimmey-jiang
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_job")
@ApiModel(value="SysJob对象", description="quartz定时任务表")
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务名")
    @TableField("job_name")
    private String jobName;

    @ApiModelProperty(value = "任务描述")
    private String description;

    @ApiModelProperty(value = "cron表达式")
    private String cron;

    @ApiModelProperty(value = "任务执行时调用的spring的bean名称")
    @TableField("bean_name")
    private String beanName;

    @ApiModelProperty(value = "任务方法名")
    @TableField("method_name")
    private String methodName;

    @ApiModelProperty(value = "任务状态（1运行中 2暂停中 3未启动)")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
