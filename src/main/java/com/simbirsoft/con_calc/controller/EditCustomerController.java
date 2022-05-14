package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerList")
public class EditCustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/editCustomer/{customer}")
    public String editCustomerPage(
            @PathVariable Customer customer,
            @AuthenticationPrincipal User user,
            Model model
            ) {
        model.addAttribute("customer", customer);
        model.addAttribute("user", user);
        return "editCustomer";
    }

    @PostMapping("/editCustomer/{customer}")
    public String updateCustomer(
            @PathVariable Customer customer,
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("customer", customer);
        model.addAttribute("user", user);
        customerRepo.save(customer);
        return "redirect:/customerList/" + user.getId() + "?";
    }
}
