package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.services.FloorResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculate/")
public class CalculateController {

    @Autowired
    FloorResultsService floorResultsService;

    @GetMapping("{floor}")
    public String calculate(@PathVariable Floor floor) {
        floorResultsService.addUpdateResults(floor);
        return "redirect:/customerList/orders/" + floor.getFrame().getCustomer().getId();
    }
}
