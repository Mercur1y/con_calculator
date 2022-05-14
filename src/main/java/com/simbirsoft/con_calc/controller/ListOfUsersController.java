package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListOfUsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String editUserPage(Model model) {
        return "userList";
    }
}
