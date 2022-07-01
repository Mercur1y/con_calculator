package com.simbirsoft.con_calc.dto.floorResults;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorResultsEditDto {

    private String nameOfOutOsb;

    private String nameOfInOsb;

    private String nameOfOverOsb;

    private String nameOfOutWind;

    private String nameOfOverWind;

    private String nameOfOutWater;

    private String nameOfOverWater;

    private String nameOfOutWarm;

    private String nameOfOverWarm;
}
