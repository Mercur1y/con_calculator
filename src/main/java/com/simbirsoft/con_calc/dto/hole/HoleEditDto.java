package com.simbirsoft.con_calc.dto.hole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoleEditDto {

    private Long id;
    private Double width;
    private Double height;
    private Short count;
}
