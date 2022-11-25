package com.herb.feigndemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String password;
    private List<ResponseAddressDTO> addresses;
}
