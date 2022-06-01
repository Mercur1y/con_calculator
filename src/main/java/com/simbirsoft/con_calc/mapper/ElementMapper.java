package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.AbstractDto;
import com.simbirsoft.con_calc.entity.AbstractElement;
import com.simbirsoft.con_calc.entity.AbstractHuman;

public interface ElementMapper<E extends AbstractElement, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
