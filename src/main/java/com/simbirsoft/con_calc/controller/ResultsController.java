package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.FoundationResults;
import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.services.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Controller
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    FrameService frameService;

    @GetMapping
    public String resultsPage (
            @RequestParam("orderId") Long orderId,
            Model model
    ) {
        model.addAttribute("orderId", orderId);
        Frame frame = frameService.findFrameById(orderId);
        Set<FloorResults> floorResults = new HashSet<>();
        Set<FoundationResults> foundationResults = new HashSet<>();
        frame.getFloors().forEach(x -> floorResults.add(x.getFloorResults()));
        frame.getFoundations().forEach(x -> foundationResults.add(x.getFoundationResults()));
//        double total =
//                floorResults
//                    .stream()
//                    .map(FloorResults::getTotalAllPrice)
//                    .reduce(Double::sum).orElse(null)
//                + foundationResults
//                    .stream()
//                    .map(FoundationResults::getTotalPrice)
//                    .reduce(Double::sum).orElseGet(null);
//        model.addAttribute("total", total);
        model.addAttribute("floorResults", floorResults);
        model.addAttribute("foundationResults", foundationResults);
        return "results";
    }
}
