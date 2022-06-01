package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.AbstractDto;
import com.simbirsoft.con_calc.entity.AbstractHuman;

interface HumanMapper<E extends AbstractHuman, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
