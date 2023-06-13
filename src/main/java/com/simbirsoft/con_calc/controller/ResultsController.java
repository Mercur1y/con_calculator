package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.customer.CustomerListDto;
import com.simbirsoft.con_calc.dto.floorResults.FloorResultsViewDto;
import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsViewDto;
import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.FoundationResults;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.mapper.CustomerMapper;
import com.simbirsoft.con_calc.mapper.FloorResultsMapper;
import com.simbirsoft.con_calc.mapper.FoundationResultsMapper;
import com.simbirsoft.con_calc.mapper.RoofResultsMapper;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/results")
public class ResultsController {

    private final OrderService orderService;
    private final CustomerMapper customerMapper;
    private final CustomerService customerService;
    private final FloorResultsMapper floorResultsMapper;
    private final FoundationResultsMapper foundationResultsMapper;
    private final RoofResultsMapper roofResultsMapper;

    @GetMapping
    public String resultsPage (
            @AuthenticationPrincipal User user,
            @RequestParam("orderId") Long orderId,
            Model model
    ) {
        model.addAttribute("orderId", orderId);

        Order order = orderService.findOrderById(orderId);
        Long customerId = order.getCustomer().getId();

        model.addAttribute("user", user);
        model.addAttribute("customerId", customerId);
        model.addAttribute("customer", customerMapper.toListDto(customerService.findCustomerById(customerId)));

        Set<FloorResultsViewDto> floorResults = new HashSet<>();

        order.getFloors().
                forEach(x -> floorResults.
                        add(floorResultsMapper.toViewDto(x.getFloorResults())));

        if (order.getFoundation() != null)
            model.addAttribute("foundationResults",
                    foundationResultsMapper.toViewDto(order.getFoundation().getFoundationResults()));

        if (order.getRoof() != null)
            model.addAttribute("roofResults",
                    roofResultsMapper.toViewDto(order.getRoof().getRoofResults()));

        model.addAttribute("floorResults", floorResults);

        return "results";
    }
}
