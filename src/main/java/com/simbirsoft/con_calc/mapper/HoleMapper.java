package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.hole.HoleCreationDto;
import com.simbirsoft.con_calc.dto.hole.HoleEditDto;
import com.simbirsoft.con_calc.entity.Hole;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HoleMapper {

    private final ModelMapper mapper;

    public Hole toCreationEntity(HoleCreationDto dto) {
        return mapper.map(dto, Hole.class);
    }

    public HoleCreationDto toCreationDto(Hole entity) {
        return mapper.map(entity, HoleCreationDto.class);
    }

    public Hole toEditEntity(HoleEditDto dto) {
        return mapper.map(dto, Hole.class);
    }

    public HoleEditDto toEditDto(Hole entity) {
        return mapper.map(entity, HoleEditDto.class);
    }
}
