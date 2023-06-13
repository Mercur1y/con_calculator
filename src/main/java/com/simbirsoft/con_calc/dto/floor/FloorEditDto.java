package com.simbirsoft.con_calc.dto.floor;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorEditDto {

    private Long id;
    private Integer number;
    @NotNull
    private Double outPerimeter;
    @NotNull
    private Double inPerimeter;
    @NotNull
    private Double height;
    @NotNull
    private Double square;
    @NotNull
    private Integer overWidth;
    @NotNull
    private Integer outWallWidth;
    @NotNull
    private Integer inWallWidth;

    private Set<HoleEditDto> holes;

    private FloorResultsEditDto floorResults;
}
