package com.simbirsoft.con_calc.mapper;

import com.simbirsoft.con_calc.dto.order.OrderListDto;
import com.simbirsoft.con_calc.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper mapper;

    public Order toListEntity(OrderListDto dto) {
        return mapper.map(dto, Order.class);
    }

    public OrderListDto toListDto(Order entity) {
        return mapper.map(entity, OrderListDto.class);
    }
}
