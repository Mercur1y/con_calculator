package com.simbirsoft.con_calc.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDto {

    private Long id;

    private String lastName;

    private String firstName;

    private String secondName;
}
