package com.brent.demo.common.exception;

import com.brent.demo.common.basecontroller.BaseC;

public class BusinessException extends RuntimeException{

    private Integer state = BaseC.FAIL_STATE;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer state,String message) {
        super(message);
        this.state = state;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Integer state,String message, Throwable cause) {
        super(message, cause);
        this.state = state;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getState() {
        return state;
    }
}
