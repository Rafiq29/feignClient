package com.herb.feigndemo.error;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestErrorResponse {

    @ApiModelProperty(notes = "Error unique ID")
    private String uuid;

    @ApiModelProperty(notes = "Error code - NOT_FOUND, INTERNAL_SERVER_ERROR etc")
    private String code;

    @ApiModelProperty(notes = "Error message")
    private String message;

    public RestErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestErrorResponse(String uuid, String code, String message) {
        this.uuid = uuid;
        this.code = code;
        this.message = message;
    }

    public RestErrorResponse(String uuid, HttpStatus httpStatus, String message) {
        this.uuid = uuid;
        this.code = getHttpCode(httpStatus);
        this.message = message;
    }

    public RestErrorResponse(String uuid, HttpStatus httpStatus) {
        this.uuid = uuid;
        this.code = getHttpCode(httpStatus);
        this.message = httpStatus.getReasonPhrase();
    }

    private String getHttpCode(HttpStatus httpStatus) {
        String[] values = httpStatus.toString().split(" ");
        return values[0];

    }
}