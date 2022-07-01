package com.simbirsoft.con_calc.dto.foundation;

import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationEditDto {

    @NotBlank
    private Double outPerimeter;
    @NotBlank
    private Double inPerimeter;

    private FoundationResultsEditDto foundationResults;
}
