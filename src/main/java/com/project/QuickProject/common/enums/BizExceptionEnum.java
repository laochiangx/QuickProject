package com.project.QuickProject.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author <a href="jimmey-jiang@foxmail.com">yy</a>
 * @version 1.0
 * @date 2020年03月25日 17:54
 * @desc ErrorEnum 业务处理错误码
 */
@AllArgsConstructor
public enum BizExceptionEnum {

    /**
     * 默认处理错误
     */
    BIZ_EXCEPTION(400000, "业务处理错误"),
    /**
     * 特定的异常，比如app需要此code进行一些操作（跳转到实名认证模块）
     * 请先实名认证后操作
     */
    NOT_VERIFIED(400001, "请先实名认证后操作");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
