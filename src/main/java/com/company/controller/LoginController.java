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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {


    @Autowired
    private UserService userService;
    @Autowired
    private SpringSecurityJwtUtil springSecurityJwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login")
    public User loginUser(@RequestBody User user) {
        System.out.println("we are in login");
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj=null;

        if(tempEmail!=null && tempPassword!=null){
            userObj=userService.getUserByEmailAndPassword(tempEmail,tempPassword);
        }
        if (userObj == null) {
            throw new UserNotFoundException("Bad credentials");
        }
        return userObj;
    }
    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception{
//        try {
////
////
////            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
////        }
////        catch (Exception e){
////            e.printStackTrace();
////            throw  new UserNotFoundException("Invalid email or password");
////        }

        UserDetails userDetails=userService.loadUserByUsername(authRequest.getEmail());

        String token = springSecurityJwtUtil.generateToken(userDetails);
        System.out.println("JWT "+token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
