package com.codewithbubblu.SPRING_BOOT_JPA.services;

import com.codewithbubblu.SPRING_BOOT_JPA.model.AppUser;
import com.codewithbubblu.SPRING_BOOT_JPA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
     UserRepository userRepository;

    public AppUser login(AppUser appUser) {
        return userRepository.loginUser(appUser.getEmail(), appUser.getPassword());
    }

    public AppUser register(AppUser appUser) {
        return userRepository.save(appUser);
    }

}
