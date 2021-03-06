package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.floorResults.FloorResultsViewDto;
import com.simbirsoft.con_calc.dto.foundationResults.FoundationResultsViewDto;
import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.FoundationResults;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.FloorResultsMapper;
import com.simbirsoft.con_calc.mapper.FoundationResultsMapper;
import com.simbirsoft.con_calc.services.OrderService;
import lombok.RequiredArgsConstructor;
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
    private final FloorResultsMapper floorResultsMapper;
    private final FoundationResultsMapper foundationResultsMapper;

    @GetMapping
    public String resultsPage (
            @RequestParam("orderId") Long orderId,
            Model model
    ) {
        model.addAttribute("orderId", orderId);
        Order order = orderService.findOrderById(orderId);

        Set<FloorResultsViewDto> floorResults = new HashSet<>();
        Set<FoundationResultsViewDto> foundationResults = new HashSet<>();

        order.getFloors().
                forEach(x -> floorResults.
                        add(floorResultsMapper.toViewDto(x.getFloorResults())));

        order.getFoundations().
                forEach(x -> foundationResults.
                        add(foundationResultsMapper.toViewDto(x.getFoundationResults())));

        model.addAttribute("floorResults", floorResults);
        model.addAttribute("foundationResults", foundationResults);
        return "results";
    }
}
