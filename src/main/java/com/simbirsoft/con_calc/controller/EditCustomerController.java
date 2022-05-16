package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.view.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/customerList/editCustomer")
public class EditCustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerService customerService;

    @GetMapping("{id}")
    public String editCustomerPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "editCustomer";
    }

    @PostMapping("{id}")
    public String updateCustomer(
            @PathVariable("id") Long id,
            @AuthenticationPrincipal User user,
            @ModelAttribute("customer") @Valid Customer customer,
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
        return "redirect:/customerList/" + user.getId() + "?";
    }
}
