package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorChoiceDto;
import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleEditDto;
import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.view.HoleRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FloorMapper {

    private final ModelMapper mapper;
    private final HoleMapper holeMapper;
    private final HoleRepo holeRepo;

    public Floor toCreationEntity(FloorCreationDto dto) {
        return mapper.map(dto, Floor.class);
    }

    public FloorCreationDto toCreationDto(Floor entity) {
        return mapper.map(entity, FloorCreationDto.class);
    }

    public Floor toEditEntity(FloorEditDto dto) {
        return mapper.map(dto, Floor.class);
    }

    public FloorEditDto toEditDto(Floor entity) {
        return mapper.map(entity, FloorEditDto.class);
    }

    public FloorChoiceDto toChoiceDto(Floor entity) {
        return mapper.map(entity, FloorChoiceDto.class);
    }

    public Floor toChoiceEntity(FloorChoiceDto dto) {
        return mapper.map(dto, Floor.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Floor.class, FloorEditDto.class)
                .addMappings(m -> m.skip(FloorEditDto::setHoles)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(FloorEditDto.class, Floor.class)
                .addMappings(m -> m.skip(Floor::setHoles)).setPostConverter(toEntityConverter());
    }

    public Converter<Floor, FloorEditDto> toDtoConverter() {
        return context -> {
            Floor source = context.getSource();
            FloorEditDto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public Converter<FloorEditDto, Floor> toEntityConverter() {
        return context -> {
            FloorEditDto source = context.getSource();
            Floor destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapSpecificFields(Floor source, FloorEditDto destination) {
        if (Objects.nonNull(source.getHoles())) {
            destination.setHoles(source.getHoles().stream().map(holeMapper::toEditDto).collect(Collectors.toSet()));
        }
    }

    private void mapSpecificFields(FloorEditDto source, Floor destination) {
        if (Objects.nonNull(source.getHoles())) {
            destination.setHoles(holeRepo.findAllByIdIn(
                    source.getHoles()
                            .stream()
                            .filter(d -> Objects.nonNull(d.getId()))
                            .map(HoleEditDto::getId)
                            .collect(Collectors.toSet()))
            );
        }
    }

}
