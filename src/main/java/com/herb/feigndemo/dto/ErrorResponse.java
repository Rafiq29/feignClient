package com.herb.feigndemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public static ErrorResponse of(Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Response.Body b = response.body();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
    }
}
