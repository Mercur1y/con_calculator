package com.simbirsoft.con_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto extends AbstractDto {

    Long id;
    String email;
    String last_name;
    String first_name;
    String second_name;
    String phone;
    String adress;
    UserDto user;
}
