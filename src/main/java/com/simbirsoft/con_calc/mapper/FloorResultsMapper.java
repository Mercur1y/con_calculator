package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.floorResults.FloorResultsViewDto;
import com.simbirsoft.con_calc.entity.FloorResults;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FloorResultsMapper {

    private final ModelMapper mapper;

    public FloorResults toEditEntity(FloorResultsEditDto dto) {
        return mapper.map(dto, FloorResults.class);
    }

    public FloorResultsEditDto toEditDto(FloorResults entity) {
        return mapper.map(entity, FloorResultsEditDto.class);
    }

    public FloorResults toViewEntity(FloorResultsViewDto dto) {
        return mapper.map(dto, FloorResults.class);
    }

    public FloorResultsViewDto toViewDto(FloorResults entity) {
        return mapper.map(entity, FloorResultsViewDto.class);
    }
}
