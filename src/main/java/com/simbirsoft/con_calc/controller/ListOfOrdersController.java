package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.view.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class ListOfOrdersController {

    final OrderService orderService;
    final OrderRepo orderRepo;

    public ListOfOrdersController(OrderService orderService, OrderRepo orderRepo) {
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/{customer}")
    public String listOfOrders (
            @PathVariable Customer customer,
            Model model
    ) {
        model.addAttribute("orders", customer.getOrders());
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
            Order order = orderService.findOrderById(orderId);
            orderRepo.delete(order);
        }
        return "redirect:/orders/" + customer.getId();
    }
}
