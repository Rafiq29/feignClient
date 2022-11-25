package com.herb.feigndemo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herb.feigndemo.dto.ErrorResponse;
import com.herb.feigndemo.error.CommonException;
import com.herb.feigndemo.error.CustomException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class FeignErrorDecoder implements ErrorDecoder {
    final ObjectMapper mapper;


    public FeignErrorDecoder() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorResponse exceptionDTO;

        try {
            exceptionDTO = mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process response body.", e);
        }


        return new CustomException(exceptionDTO.getMessage(), exceptionDTO.getPath(), exceptionDTO.getError(), exceptionDTO.getStatus());
    }
}
