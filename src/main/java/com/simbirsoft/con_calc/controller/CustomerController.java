package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.customer.CustomerEditDto;
import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.CustomerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/add")
    public String inputPage() {
        return "newCustomer";
    }

    @PostMapping("/add")
    public String add(
            @AuthenticationPrincipal User user,
            @ModelAttribute("customer") @Valid CustomerCreationDto customer,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = UtilsController.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "newCustomer";
        } else {
            customerService.addCustomerToUser(customer, user);
        }
        return "redirect:/main";
    }

    @GetMapping("/edit")
    public String editCustomerPage(
            @RequestParam("customerId") Long id,
            Model model
    ) {
        model.addAttribute("customer", customerService.getForEdit(id));
        return "editCustomer";
    }

    @PostMapping("/edit")
    public String updateCustomer(
            @RequestParam("customerId") Long id,
            @ModelAttribute("customer") @Valid CustomerEditDto customer,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = UtilsController.getErrors(bindingResult);
            model.mergeAttributes(errors);
            System.out.println(errors);
            return "editCustomer";
        }
        customerService.updateCustomer(customer, id);
        return "redirect:/main";
    }
}
