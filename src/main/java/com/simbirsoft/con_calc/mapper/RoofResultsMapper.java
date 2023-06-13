package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.roofResults.RoofResultsEditDto;
import com.simbirsoft.con_calc.dto.roofResults.RoofResultsViewDto;
import com.simbirsoft.con_calc.entity.RoofResults;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoofResultsMapper {

    private final ModelMapper mapper;

    public RoofResults toEditEntity(RoofResultsEditDto dto) {
        return mapper.map(dto, RoofResults.class);
    }

    public RoofResultsEditDto toEditDto(RoofResults entity) {
        return mapper.map(entity, RoofResultsEditDto.class);
    }

    public RoofResults toViewEntity(RoofResultsViewDto dto) {
        return mapper.map(dto, RoofResults.class);
    }

    public RoofResultsViewDto toViewDto(RoofResults entity) {
        return mapper.map(entity, RoofResultsViewDto.class);
    }
}
