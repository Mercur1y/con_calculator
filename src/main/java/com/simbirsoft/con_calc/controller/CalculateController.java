package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.services.FloorResultsService;
import com.simbirsoft.con_calc.services.FoundationResultsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calculate/")
public class CalculateController {

    private final FloorResultsService floorResultsService;
    private final FoundationResultsService foundationResultsService;

    @GetMapping("{floor}")
    public String calculate(@PathVariable Floor floor) {
        floorResultsService.addUpdateResults(floor);
        return "redirect:/orders/" + floor.getOrder().getCustomer().getId();
    }

    @GetMapping("foundation/{foundation}")
    public String calculateFoundation(@PathVariable Foundation foundation) {
        foundationResultsService.addUpdateResults(foundation);
        return "redirect:/orders/" + foundation.getOrder().getCustomer().getId();
    }
}
