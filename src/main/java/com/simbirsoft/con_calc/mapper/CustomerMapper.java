package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.CustomerDto;
import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final ModelMapper mapper;

    public Customer toEntity(CustomerDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Customer.class);
    }

    public CustomerDto toDto(Customer entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CustomerDto.class);
    }
}
