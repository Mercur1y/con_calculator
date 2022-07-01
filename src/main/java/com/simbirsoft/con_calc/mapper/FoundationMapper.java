package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.floor.FloorChoiceDto;
import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationChoiceDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationCreationDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoundationMapper {

    private final ModelMapper mapper;

    public Foundation toCreationEntity(FoundationCreationDto dto) {
        return mapper.map(dto, Foundation.class);
    }

    public FoundationCreationDto toCreationDto(Foundation entity) {
        return mapper.map(entity, FoundationCreationDto.class);
    }

    public Foundation toEditEntity(FoundationEditDto dto) {
        return mapper.map(dto, Foundation.class);
    }

    public FoundationEditDto toEditDto(Foundation entity) {
        return mapper.map(entity, FoundationEditDto.class);
    }

    public FoundationChoiceDto toChoiceDto(Foundation entity) {
        return mapper.map(entity, FoundationChoiceDto.class);
    }

    public Foundation toChoiceEntity(FoundationChoiceDto dto) {
        return mapper.map(dto, Foundation.class);
    }
}
