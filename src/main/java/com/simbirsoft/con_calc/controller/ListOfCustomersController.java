package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.CustomerDto;
import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import com.simbirsoft.con_calc.view.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class ListOfCustomersController {

    private final CustomerRepo customerRepo;
    private final UserService userService;

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("customers", userService.get(user.getId()).getCustomers());
        return "customerList";
    }

    @PostMapping
    public String  deleteCustomer(
            @RequestParam(required = true, defaultValue = "" ) Long customerId,
            @RequestParam(required = true, defaultValue = "" ) String action
    ) {

        System.out.println(customerId);
        if (action.equals("delete")){
            customerRepo.deleteById(customerId);
        }
        return "redirect:/main";
    }

}
