package com.simbirsoft.con_calc.dto.foundationResults;

import com.simbirsoft.con_calc.dto.foundation.FoundationChoiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoundationResultsViewDto {

    private String nameOfPiles;

    private Integer countOfPiles;

    private Double priceOfPiles;

    private String nameOfConcrete;

    private Double volumeOfConcrete;

    private Double priceOfConcrete;

    private String nameOfBigArm;

    private Integer countOfBigArm;

    private Double priceOfBigArm;

    private String nameOfSmallArm;

    private Integer countOfSmallArm;

    private Double priceOfSmallArm;

    private String nameOfWood;

    private Double volumeOfWood;

    private Double priceOfWood;

    private String nameOfBalk;

    private Double volumeOfBalk;

    private Double priceOfBalk;

    private Double totalPriceOfGrillage;

    private Double totalPriceOfFormwork;

    private Double totalPrice;

    private FoundationChoiceDto foundation;
}
