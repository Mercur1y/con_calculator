package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.view.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/choice")
public class ChoiceController {

    final OrderService orderService;

    public ChoiceController(OrderService orderService) {
        this.orderService = orderService;
    }

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
        Order order = orderService.findOrderById(orderId);
        model.addAttribute("order", order);
        model.addAttribute("floors", order.getFloors());
        model.addAttribute("foundations", order.getFoundations());
        return "choiceExists";
    }
}
