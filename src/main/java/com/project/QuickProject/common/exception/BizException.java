package com.project.QuickProject.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import com.project.QuickProject.common.enums.BizExceptionEnum;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class BizException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 8073588683551379959L;

    private BizExceptionEnum bizExceptionEnum = BizExceptionEnum.BIZ_EXCEPTION;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getMessage());
        this.bizExceptionEnum = bizExceptionEnum;
    }
}
