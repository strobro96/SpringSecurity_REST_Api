package ru.stroich.springsecurity6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stroich.springsecurity6.model.User;
import ru.stroich.springsecurity6.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping ("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String homePage(Principal principal, ModelMap model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("userLog", user);
        return "home";
    }
}
