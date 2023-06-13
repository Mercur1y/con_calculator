package com.simbirsoft.con_calc.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListDto {

    private Long id;

    private String adress;

    private String localDateTime;

    private String status;
}
