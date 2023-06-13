package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import com.simbirsoft.con_calc.services.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final UserService userService;
    private final UtilsService utilsService;

    @GetMapping("/")
    public String greeting(
            @AuthenticationPrincipal User user,
            Model model) {

        if (!userService.isAdminAdded()) utilsService.initDB();
        model.addAttribute("user", user);
        return "login";
    }
}
