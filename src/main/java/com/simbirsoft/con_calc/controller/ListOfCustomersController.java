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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class ListOfCustomersController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/customerList/{user}")
    public String main(
            @PathVariable User user,
            @AuthenticationPrincipal User currentUser,
            Model model
    ) {
        Set<Customer> customersSet = user.getCustomers();
//        System.out.println(customersSet);
//        System.out.println(currentUser.getId());
        model.addAttribute("customers", customersSet);
        model.addAttribute("user", currentUser);
        return "customerList";
    }

    @PostMapping("/customerList/{user}")
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
