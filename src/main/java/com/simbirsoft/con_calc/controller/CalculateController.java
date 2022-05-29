package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.services.FloorResultsService;
import com.simbirsoft.con_calc.services.FoundationResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;

@Controller
@RequestMapping("/calculate/")
public class CalculateController {

    @Autowired
    FloorResultsService floorResultsService;

    @Autowired
    FoundationResultsService foundationResultsService;

    @GetMapping("{floor}")
    public String calculate(@PathVariable Floor floor) {
        floorResultsService.addUpdateResults(floor);
        return "redirect:/customerList/orders/" + floor.getFrame().getCustomer().getId();
    }

    @GetMapping("foundation/{foundation}")
    public String calculateFoundation(@PathVariable Foundation foundation) {
        foundationResultsService.addUpdateResults(foundation);
        return "redirect:/customerList/orders/" + foundation.getFrame().getCustomer().getId();
    }
}
