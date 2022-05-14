package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class EditUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/editUser/{user}")
    public String editUserPage(
            @PathVariable User user,
            Model model
    ) {
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/editUser/{user}")
    public String updateProfile(
            @PathVariable User user,
            Model model) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
