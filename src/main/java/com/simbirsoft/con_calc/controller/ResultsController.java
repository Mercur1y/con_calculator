package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.services.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Controller
@RequestMapping("/results")
public class ResultsController {

    @Autowired
    FrameService frameService;

    @GetMapping("{id}")
    public String resultsPage (
            @PathVariable Long id,
            Model model
    ) {
        Frame frame = frameService.findFrameById(id);
        Set<FloorResults> resultsSet = new HashSet<>();
        frame.getFloors().forEach(x -> resultsSet.add(x.getFloorResults()));
        model.addAttribute("results", resultsSet);
        return "results";
    }
}
