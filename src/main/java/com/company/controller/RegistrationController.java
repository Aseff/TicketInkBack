package com.company.controller;


import com.company.exception.UserNotFoundException;
import com.company.model.AuthRequest;
import com.company.model.JwtResponse;
import com.company.model.User;
import com.company.service.UserService;
import com.company.util.SpringSecurityJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/add")
    public User registerUser(@RequestBody User user) {
        String tempEmail = user.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userobj = userService.getUserByEmail(tempEmail);
            if (userobj != null) {
                throw new UserNotFoundException("User with " + tempEmail + " is already exist");
            }
        }

        User userObj = null;
        userObj = userService.addUser(user);
        return userObj;

    }



}
