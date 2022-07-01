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
public class ValidDtoForFloor {

    @NotBlank
    private String nameOfOutOsb;
    @NotBlank
    private String nameOfInOsb;
    @NotBlank
    private String nameOfOverOsb;
    @NotBlank
    private String nameOfOutWind;
    @NotBlank
    private String nameOfOverWind;
    @NotBlank
    private String nameOfOutWater;
    @NotBlank
    private String nameOfOverWater;
    @NotBlank
    private String nameOfOutWarm;
    @NotBlank
    private String nameOfOverWarm;
}
