package com.simbirsoft.con_calc.dto.order;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderViewDto {

    private Long id;

    private FloorResultsViewDto floorResults;
}
