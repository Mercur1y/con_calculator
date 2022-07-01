package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.customer.CustomerEditDto;
import com.simbirsoft.con_calc.dto.customer.CustomerListDto;
import com.simbirsoft.con_calc.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final ModelMapper mapper;

    public Customer toCreationEntity(CustomerCreationDto dto) {
        return mapper.map(dto, Customer.class);
    }

    public CustomerCreationDto toCreationDto(Customer entity) {
        return mapper.map(entity, CustomerCreationDto.class);
    }

    public Customer toListEntity(CustomerListDto dto) {
        return mapper.map(dto, Customer.class);
    }

    public CustomerListDto toListDto(Customer entity) {
        return mapper.map(entity, CustomerListDto.class);
    }

    public Customer toEditEntity(CustomerEditDto dto) {
        return mapper.map(dto, Customer.class);
    }

    public CustomerEditDto toEditDto(Customer entity) {
        return mapper.map(entity, CustomerEditDto.class);
    }
}
