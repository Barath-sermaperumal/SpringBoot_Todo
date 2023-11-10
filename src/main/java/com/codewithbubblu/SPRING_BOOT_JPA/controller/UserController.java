package com.codewithbubblu.SPRING_BOOT_JPA.controller;

import com.codewithbubblu.SPRING_BOOT_JPA.model.AppUser;
import com.codewithbubblu.SPRING_BOOT_JPA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public AppUser login(@RequestBody AppUser appUser){
        return userService.login(appUser);
    }

    @RequestMapping("/register")
    public AppUser register(@RequestBody AppUser appUser){
        return userService.register(appUser);
    }
}
