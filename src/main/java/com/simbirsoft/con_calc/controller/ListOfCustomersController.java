package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/main")
public class ListOfCustomersController {

    final CustomerRepo customerRepo;

    public ListOfCustomersController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        Set<Customer> customersSet = user.getCustomers();
        model.addAttribute("customers", customersSet);
        return "customerList";
    }

    @PostMapping
    public String  deleteCustomer(
            @PathVariable User user,
            @RequestParam(required = true, defaultValue = "" ) Long customerId,
            @RequestParam(required = true, defaultValue = "" ) String action,
            Model model) {

        System.out.println(customerId);
        if (action.equals("delete")){
            customerRepo.deleteById(customerId);
        }
        return "redirect:/customerList/" + user.getId() + "?";
    }

}
