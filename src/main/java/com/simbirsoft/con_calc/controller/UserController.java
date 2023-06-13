package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.user.UserCreationDto;
import com.simbirsoft.con_calc.dto.user.UserEditDto;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.UserService;
import com.simbirsoft.con_calc.services.UtilsService;
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


    @GetMapping("/user/new")
    public String addUserPage(Model model) {
        model.addAttribute("userForm", new User());

        return "newUser";
    }

    @PostMapping("/user/new")
    public String addUser(
            @Valid UserCreationDto userForm,
            BindingResult bindingResult,
            Model model) {

        if (!userService.add(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "newUser";
        }

        return "redirect:/admin";
    }

    @GetMapping("/user/{id}")
    public String editUserPage(
            @PathVariable("id") Long id,
            Model model
    ) {
        model.addAttribute("user", userService.getForEdit(id));
        return "editUser";
    }

    @PostMapping("/user/{id}")
    public String updateUser(
            @PathVariable("id") Long id,
            @RequestParam("status") String status,
            @ModelAttribute("user") UserEditDto user
    ) {
        user.setStatus(status);
        userService.updateUser(user, id);
        return "redirect:/admin";
    }
}
