package com.herb.feigndemo.error;

import com.herb.feigndemo.dto.ErrorResponse;
import feign.Response;
import feign.error.FeignExceptionConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends CommonException {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    @FeignExceptionConstructor
    public CustomException(String message, String path, String error, HttpStatus status) {
        super(message);
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
