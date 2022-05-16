package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Map;

@Controller
@RequestMapping("/addCustomer")
public class AddCustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping
    public String inputPage() {
        return "newCustomer";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Customer customer,
            BindingResult bindingResult,
            Model model
    ) {
        customer.setUser(user);
        model.addAttribute("customer", customer);
        model.addAttribute("user", user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = UtilsController.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "newCustomer";
        } else {
            customerRepo.save(customer);
        }

        return "redirect:/customerList/" + user.getId() + "?";
    }
}
