package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsEditDto;
import com.simbirsoft.con_calc.dto.floorResults.FloorResultsViewDto;
import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsEditDto;
import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsViewDto;
import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.FoundationResults;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoundationResultsMapper {

    private final ModelMapper mapper;

    public FoundationResults toEditEntity(FoundationResultsEditDto dto) {
        return mapper.map(dto, FoundationResults.class);
    }

    public FoundationResultsEditDto toEditDto(FoundationResults entity) {
        return mapper.map(entity, FoundationResultsEditDto.class);
    }

    public FoundationResults toViewEntity(FoundationResultsViewDto dto) {
        return mapper.map(dto, FoundationResults.class);
    }

    public FoundationResultsViewDto toViewDto(FoundationResults entity) {
        return mapper.map(entity, FoundationResultsViewDto.class);
    }
}
