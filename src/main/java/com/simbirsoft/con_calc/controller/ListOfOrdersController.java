package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.FrameService;
import com.simbirsoft.con_calc.view.FrameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customerList/orders")
public class ListOfOrdersController {

    @Autowired
    FrameService frameService;

    @Autowired
    FrameRepo frameRepo;

    @GetMapping("/{customer}")
    public String listOfOrders (
            @PathVariable Customer customer,
            Model model
    ) {
        model.addAttribute("orders", customer.getFrames());
        model.addAttribute("customer", customer);
        return "orders";
    }

    @PostMapping("{customer}")
    public String deleteOrder (
            @PathVariable Customer customer,
            @RequestParam(required = true, defaultValue = "" ) Long orderId,
            @RequestParam(required = true, defaultValue = "" ) String action,
            Model model) {

        if (action.equals("delete")){
            Frame frame = frameService.findFrameById(orderId);
            frameRepo.delete(frame);
        }
        return "redirect:/customerList/orders/" + customer.getId();
    }
}
