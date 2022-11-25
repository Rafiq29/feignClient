package com.herb.feigndemo.error;

import feign.error.FeignExceptionConstructor;
import feign.error.ResponseBody;


public class CommonException extends RuntimeException{
    private  String errorCode;
    private  String errorMessage;

    public CommonException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public CommonException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @FeignExceptionConstructor
    public CommonException(@ResponseBody RestErrorResponse errorResponse) {
        if (errorResponse != null) {
            this.errorCode = errorResponse.getCode();
            this.errorMessage = errorResponse.getMessage();
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}
