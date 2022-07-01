package com.simbirsoft.con_calc.dto.floor;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorEditDto {

    private Long id;
    @NotBlank
    private Double outPerimeter;
    @NotBlank
    private Double inPerimeter;
    @NotBlank
    private Double height;
    @NotBlank
    private Double square;
    @NotBlank
    private Integer overWidth;
    @NotBlank
    private Integer outWallWidth;
    @NotBlank
    private Integer inWallWidth;

    private Set<HoleEditDto> holes;

    private FloorResultsEditDto floorResults;
}
