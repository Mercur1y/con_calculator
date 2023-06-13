package com.simbirsoft.con_calc.dto.roofResults;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoofResultsEditDto {

    private String nameOfWater;

    private String nameOfWarm;

    private String nameOfTop;
}
