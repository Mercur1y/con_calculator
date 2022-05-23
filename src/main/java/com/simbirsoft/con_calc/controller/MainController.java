package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main( @AuthenticationPrincipal User user) {
        return "redirect:/customerList/" + user.getId();
    }
}
