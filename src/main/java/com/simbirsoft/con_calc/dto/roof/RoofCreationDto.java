package com.simbirsoft.con_calc.dto.roof;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoofCreationDto {
    Double length;

    Double width;

    Double height;

    Double overhang;

    Integer type;
}
