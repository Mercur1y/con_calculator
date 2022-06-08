package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.CustomerDto;
import com.simbirsoft.con_calc.dto.UserCreationDto;
import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;
    private final CustomerMapper customerMapper;
    private final CustomerRepo customerRepo;

    public User toCreationEntity(UserCreationDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    public UserCreationDto toCreationDto(User entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserCreationDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(m -> m.skip(UserDto::setCustomers)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(UserDto.class, User.class)
                .addMappings(m -> m.skip(User::setCustomers)).setPostConverter(toEntityConverter());
    }


    public User toEntity(UserDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    public UserDto toDto(User entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }

    public Converter<User, UserDto> toDtoConverter() {
        return context -> {
            User source = context.getSource();
            UserDto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public Converter<UserDto, User> toEntityConverter() {
        return context -> {
            UserDto source = context.getSource();
            User destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapSpecificFields(User source, UserDto destination) {
        if (Objects.nonNull(source.getCustomers())) {
            destination.setCustomers(source.getCustomers().stream().map(customerMapper::toDto).collect(Collectors.toSet()));
        }
    }

    private void mapSpecificFields(UserDto source, User destination) {
        if (Objects.nonNull(source.getCustomers())) {
            destination.setCustomers(customerRepo.findAllByIdIn(
                    source.getCustomers()
                            .stream()
                            .filter(d -> Objects.nonNull(d.getId()))
                            .map(CustomerDto::getId)
                            .collect(Collectors.toSet()))
            );
        }
    }
}
