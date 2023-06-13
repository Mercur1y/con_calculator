package com.simbirsoft.con_calc.dto.roof;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.roofResults.RoofResultsEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoofEditDto {

    Long id;

    Double length;

    Double width;

    Double height;

    Double overhang;

    Integer type;

    private RoofResultsEditDto roofResults;
}
