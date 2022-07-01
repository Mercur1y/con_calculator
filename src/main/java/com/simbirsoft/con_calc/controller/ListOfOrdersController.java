package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.view.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class ListOfOrdersController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final OrderRepo orderRepo;

    @GetMapping("/{customerId}")
    public String listOfOrders (
            @PathVariable Long customerId,
            Model model
    ) {
        model.addAttribute("orders", customerService.getDtoOrdersByCustomerId(customerId));
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
