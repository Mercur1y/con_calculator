package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.UserCreationDto;
import com.simbirsoft.con_calc.dto.UserDto;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String userList(
            Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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


    @GetMapping("/user/add")
    public String addUserPage(Model model) {
        model.addAttribute("userForm", new User());

        return "newUser";
    }

    @PostMapping("/user/add")
    public String addUser(
            @Valid UserCreationDto userForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
                Map<String, String> errors = UtilsController.getErrors(bindingResult);
                model.mergeAttributes(errors);
            System.out.println(errors);
            model.addAttribute("user", userForm);
            return "newUser";
            }

        if (!userService.add(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "newUser";
        }

        return "redirect:/admin";
    }

    @GetMapping("/user/edit/{id}")
    public String editUserPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("user", userService.get(id));
        return "editUser";
    }

    @PostMapping("/user/edit/{id}")
    public String updateUser(
            @PathVariable("id") Long id,
            @RequestParam("status") String status,
            @ModelAttribute("user") UserDto user
    ) {
        user.setStatus(status);
        userService.updateUser(user, id);
        return "redirect:/admin";
    }
}
