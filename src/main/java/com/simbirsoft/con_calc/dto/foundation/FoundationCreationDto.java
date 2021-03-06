package com.simbirsoft.con_calc.dto.foundation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationCreationDto {

    private Integer number;
    @NotBlank
    private Double outPerimeter;
    @NotBlank
    private Double inPerimeter;
}
