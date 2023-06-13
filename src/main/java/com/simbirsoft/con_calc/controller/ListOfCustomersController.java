package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.customer.CustomerEditDto;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.services.UserService;
import com.simbirsoft.con_calc.view.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class ListOfCustomersController {

    private final CustomerService customerService;
    private final UserService userService;

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("customers", userService.getDtoCustomersByUserId(user.getId()));
        return "customerList";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @ModelAttribute("customer") @Valid CustomerCreationDto customer,
            BindingResult bindingResult,
            Model model
    ) {

        customerService.addCustomerToUser(customer, user);
        return "redirect:/main";
    }

    @PostMapping("/update")
    public String updateCustomer(
            @RequestParam("customerId") Long id,
            @ModelAttribute("customer") @Valid CustomerEditDto customer
            ) {
        customerService.updateCustomer(customer, id);
        return "redirect:/main";
    }

    @PostMapping("/delete")
    public String  deleteCustomer(
            @RequestParam(required = true, defaultValue = "" ) Long customerId,
            @RequestParam(required = true, defaultValue = "" ) String action
    ) {

        System.out.println(customerId);
        if (action.equals("delete")){
            customerService.deleteCustomer(customerId);
        }
        return "redirect:/main";
    }

}
