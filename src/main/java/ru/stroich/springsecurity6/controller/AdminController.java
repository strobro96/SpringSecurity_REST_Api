package ru.stroich.springsecurity6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.stroich.springsecurity6.model.User;
import ru.stroich.springsecurity6.service.RoleService;
import ru.stroich.springsecurity6.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "table";
    }

    @GetMapping("/addUser")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", roleService.getAllRoles());
        return "user-info";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {

        if (user.getId() == null) {
            userService.saveUser(user);
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listRoles", roleService.getAllRoles());
        return "user-info";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
