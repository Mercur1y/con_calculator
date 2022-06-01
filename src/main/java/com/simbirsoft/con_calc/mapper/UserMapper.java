package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.AbstractHuman;
import com.simbirsoft.con_calc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractHumanMapper<User, UserDto> {

    @Autowired
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
