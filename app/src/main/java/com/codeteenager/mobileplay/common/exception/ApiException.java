package com.codeteenager.mobileplay.common.exception;

/**
 * Created by wangrui on 2017/9/1.
 */

public class ApiException extends BaseException {

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
