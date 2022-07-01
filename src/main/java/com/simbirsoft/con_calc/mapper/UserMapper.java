package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.user.UserCreationDto;
import com.simbirsoft.con_calc.dto.user.UserEditDto;
import com.simbirsoft.con_calc.dto.user.UserListDto;
import com.simbirsoft.con_calc.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;

    public User toListEntity(UserListDto dto) {
        return mapper.map(dto, User.class);
    }

    public UserListDto toListDto(User entity) {
        return mapper.map(entity, UserListDto.class);
    }

    public User toCreationEntity(UserCreationDto dto) {
        return mapper.map(dto, User.class);
    }

    public UserCreationDto toCreationDto(User entity) {
        return mapper.map(entity, UserCreationDto.class);
    }

    public User toEditEntity(UserEditDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

    public UserEditDto toEditDto(User entity) {
        return mapper.map(entity, UserEditDto.class);
    }
}
