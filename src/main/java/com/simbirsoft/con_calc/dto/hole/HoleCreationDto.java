package com.simbirsoft.con_calc.dto.hole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoleCreationDto {

    @NotBlank
    private Double width;
    @NotBlank
    private Double height;
    @NotBlank
    private Short count;
}
