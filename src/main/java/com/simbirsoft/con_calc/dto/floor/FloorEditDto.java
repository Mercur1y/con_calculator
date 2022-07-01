package com.simbirsoft.con_calc.dto.floor;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorEditDto {

    private Long id;

    private Double outPerimeter;

    private Double inPerimeter;

    private Double height;

    private Double square;

    private Integer overWidth;

    private Integer outWallWidth;

    private Integer inWallWidth;

    private Set<HoleEditDto> holes;

    private FloorResultsEditDto floorResults;
}
