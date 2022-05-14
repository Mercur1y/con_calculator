package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AddUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/newuser")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "newuser";
    }

    @PostMapping("/newuser")
    public String addUser(
            @Valid User userForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
                Map<String, String> errors = UtilsController.getErrors(bindingResult);
                model.mergeAttributes(errors);
            System.out.println(errors);
            model.addAttribute("user", userForm);
            return "newuser";
            }

        if (!userService.addUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "newuser";
        }

        return "redirect:/admin";
    }
}
