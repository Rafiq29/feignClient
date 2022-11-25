package com.herb.feigndemo.util;

import com.herb.feigndemo.config.FeignConfiguration;
import com.herb.feigndemo.dto.CreateUserDTO;
import com.herb.feigndemo.dto.UserDTO;
import com.herb.feigndemo.error.CustomException;
import feign.error.ErrorHandling;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "feignDemo", url = "http://localhost:8080/users", configuration = {FeignConfiguration.class})
public interface FeignServiceUtil {

    @PostMapping("/add")
    String add(@RequestBody CreateUserDTO userDTO);

    @GetMapping
    @ErrorHandling(defaultException = CustomException.class)
    List<UserDTO> getAll();

    @GetMapping("/{id}")
    UserDTO getByID(@PathVariable("id") Long id);
}
