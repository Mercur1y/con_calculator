package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.floor.FloorChoiceDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationChoiceDto;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.FloorMapper;
import com.simbirsoft.con_calc.mapper.FoundationMapper;
import com.simbirsoft.con_calc.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/choice")
public class ChoiceController {

    private final OrderService orderService;
    private final FloorMapper floorMapper;
    private final FoundationMapper foundationMapper;

    @GetMapping
    public String choiceNew(
            @RequestParam(required = true, defaultValue = "") Long customerId,
            Model model
    ) {
        model.addAttribute("customerId", customerId);
        return "choice";
    }

    @GetMapping("/order")
    public String choiceAdd(
            @RequestParam(required = true, defaultValue = "") Long orderId,
            Model model
    ) {
        model.addAttribute("orderId", orderId);
        return "choice";
    }

    @GetMapping
    public String choiceBD(
            @RequestParam("orderId") Long orderId,
            Model model
    ) {

        Order order = orderService.findOrderById(orderId);

        Set<FloorChoiceDto> floors = new HashSet<>();
        Set<FoundationChoiceDto> foundations = new HashSet<>();

        order.getFloors().forEach(x -> floors.add(floorMapper.toChoiceDto(x)));
        order.getFoundations().forEach(x -> foundations.add(foundationMapper.toChoiceDto(x)));

        model.addAttribute("floors", floors);
        model.addAttribute("foundations", foundations);
        return "choiceExists";
    }
}
