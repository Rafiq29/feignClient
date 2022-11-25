package com.herb.feigndemo.controller;

import com.herb.feigndemo.dto.CreateUserDTO;
import com.herb.feigndemo.dto.UserDTO;
import com.herb.feigndemo.util.FeignServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feign")
public class FeignController {
    private final FeignServiceUtil serviceUtil;

    @PostMapping("/user/add")
    public String userAdd(@RequestBody CreateUserDTO userDTO) {
        serviceUtil.add(userDTO);
        return "User created!";
    }

    @GetMapping("/users")
    public List<UserDTO> userGetAll() {
        return serviceUtil.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO userGetByID(@PathVariable("id") Long id) {
        return serviceUtil.getByID(id);
    }
}
