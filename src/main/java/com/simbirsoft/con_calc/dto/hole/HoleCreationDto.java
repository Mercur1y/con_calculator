package com.simbirsoft.con_calc.dto.hole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoleCreationDto {

    private Double width;

    private Double height;

    private Short count;
}
