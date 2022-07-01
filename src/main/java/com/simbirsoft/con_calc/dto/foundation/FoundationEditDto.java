package com.simbirsoft.con_calc.dto.foundation;

import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsEditDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationEditDto {

    private Double outPerimeter;

    private Double inPerimeter;

    private FoundationResultsEditDto foundationResults;
}
