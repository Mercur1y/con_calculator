package com.simbirsoft.con_calc.dto.floor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

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
}
