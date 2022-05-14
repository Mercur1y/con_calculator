package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class GreetingController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting(
            @AuthenticationPrincipal User user,
            Model model) {

        if (!userService.isAdminAdded()) userService.initDB();
        model.addAttribute("user", user);
        return "login";
    }
}
