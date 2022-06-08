package com.simbirsoft.con_calc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    Long id;
    String email;
    String last_name;
    String first_name;
    String second_name;
    String phone;
    String adress;
}
