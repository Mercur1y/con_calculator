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
public class ValidDtoForFoundation {

    @NotBlank
    private String nameOfPiles;
    @NotBlank
    private String nameOfConcrete;
}
