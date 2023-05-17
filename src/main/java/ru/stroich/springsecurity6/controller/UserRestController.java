package ru.stroich.springsecurity6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.stroich.springsecurity6.model.User;

@RestController
@RequestMapping("api/user/")
public class UserRestController {

    @GetMapping()
    public ResponseEntity<User> getUserHomePage() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}