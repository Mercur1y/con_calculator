package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/customerList")
public class ListOfCustomersController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("{user}")
    public String main(
            @PathVariable User user,
            Model model
    ) {
        Set<Customer> customersSet = user.getCustomers();
        model.addAttribute("customers", customersSet);
        model.addAttribute("user", user);
        return "customerList";
    }

    @PostMapping("{user}")
    public String  deleteUser(
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
