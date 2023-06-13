package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.dto.roof.RoofChoiceDto;
import com.simbirsoft.con_calc.dto.roof.RoofCreationDto;
import com.simbirsoft.con_calc.dto.roof.RoofEditDto;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Roof;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoofMapper {
    
    private final ModelMapper mapper;

    public Roof toCreationEntity(RoofCreationDto dto) {
        return mapper.map(dto, Roof.class);
    }

    public RoofCreationDto toCreationDto(Roof entity) {
        return mapper.map(entity, RoofCreationDto.class);
    }

    public RoofChoiceDto toChoiceDto(Roof entity) {
        return mapper.map(entity, RoofChoiceDto.class);
    }

    public Roof toChoiceEntity(RoofChoiceDto dto) {
        return mapper.map(dto, Roof.class);
    }

    public Roof toEditEntity(RoofEditDto dto) {
        return mapper.map(dto, Roof.class);
    }

    public RoofEditDto toEditDto(Roof entity) {
        return mapper.map(entity, RoofEditDto.class);
    }
}
