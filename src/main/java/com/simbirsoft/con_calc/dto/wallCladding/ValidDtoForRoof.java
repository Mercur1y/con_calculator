package com.simbirsoft.con_calc.dto.wallCladding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidDtoForRoof {
    @NotBlank
    private String nameOfWarm;
    @NotBlank
    private String nameOfWater;
    @NotBlank
    private String nameOfTop;
}
