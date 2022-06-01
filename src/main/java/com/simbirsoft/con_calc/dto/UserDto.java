package com.simbirsoft.con_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends AbstractDto {

    Long id;
    String username;
    String email;
    String last_name;
    String first_name;
    String second_name;
    String phone;
    String status;
    Set<RoleDto> roles;
    Set<CustomerDto> customers;
}
