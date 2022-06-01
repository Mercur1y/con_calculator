package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String userList(
            Model model) {
        model.addAttribute("users", userService.allUsers());
        return "admin";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin")
    public String  deleteUser(
            @RequestParam(required = true, defaultValue = "" ) Long userId,
            @RequestParam(required = true, defaultValue = "" ) String action,
            Model model) {

        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }


    @GetMapping("/add")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "newUser";
    }

    @PostMapping("/add")
    public String addUser(
            @Valid User userForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
                Map<String, String> errors = UtilsController.getErrors(bindingResult);
                model.mergeAttributes(errors);
            System.out.println(errors);
            model.addAttribute("user", userForm);
            return "newUser";
            }

        if (!userService.addUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "newUser";
        }

        return "redirect:/admin";
    }

    @GetMapping("edit/{id}")
    public String editUserPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("edit/{id}")
    public String updateProfile(
            @PathVariable("id") Long id,
            @RequestParam("status") String status,
            @ModelAttribute("user") User user
    ) {
        user.setStatus(status);
        userService.updateUser(user, id);
        return "redirect:/admin";
    }
}
