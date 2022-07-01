package com.simbirsoft.con_calc.dto.foundation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationCreationDto {

    private Integer number;

    private Double outPerimeter;

    private Double inPerimeter;
}
