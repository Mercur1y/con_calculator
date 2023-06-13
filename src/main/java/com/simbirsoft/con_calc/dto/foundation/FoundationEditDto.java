package com.simbirsoft.con_calc.dto.foundation;

import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationEditDto {

    @NotNull
    private Double outPerimeter;
    @NotNull
    private Double inPerimeter;

    private FoundationResultsEditDto foundationResults;
}
