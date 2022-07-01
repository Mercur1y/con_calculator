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
    @NotBlank
    private Boolean isFirst;
}
