package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.view.FrameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/choice")
public class ChoiceController {

    @Autowired
    FrameRepo frameRepo;

    @GetMapping
    public String choiceNew (
            @RequestParam(required = true, defaultValue = "") Long customerId,
            Model model
    ) {
        model.addAttribute("customerId", customerId);
        return "choice";
    }

    @GetMapping("/add")
    public String choiceAdd (
            @RequestParam(required = true, defaultValue = "") Long orderId,
            Model model
    ) {
        model.addAttribute("orderId", orderId);
        return "choice";
    }

    @GetMapping ("/edit")
    public String choiceBD (
            @RequestParam("orderId") Long orderId,
            Model model
            ) {
        Frame frame = frameRepo.getById(orderId);
        model.addAttribute("frame", frame);
        model.addAttribute("floors", frame.getFloors());
        model.addAttribute("foundations", frame.getFoundations());
        return "choiceExists";
    }
}
