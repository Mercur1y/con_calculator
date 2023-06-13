package com.simbirsoft.con_calc.dto.floor;

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
public class FloorCreationDto {

    private Integer number;
    private Double outPerimeter;
    private Double inPerimeter;
    private Double height;
    private Double square;
    private Integer overWidth;
    private Integer outWallWidth;
    private Integer inWallWidth;
    private Boolean isFirst;
    private Set<HoleEditDto> holes;
}
