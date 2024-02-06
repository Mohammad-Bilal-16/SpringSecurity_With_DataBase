package com.example.secureApplicationwithDB.controller;

import com.example.secureApplicationwithDB.model.User;
import com.example.secureApplicationwithDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/student/signup")
    public User studentSignUpPage(@RequestParam("username") String username,
                                  @RequestParam("password") String password){
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities("login_student::access_library")
                .build();
        return userService.save(user);
    }

    @PostMapping("/faculty/signup")
    public User facultySignUpPage(@RequestParam("username") String username,
                                  @RequestParam("password") String password){
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities("login_faculty::access_library")
                .build();
        return userService.save(user);
    }

    @GetMapping("/home")                //all
    public String helloPage(){
        return "This is Hello Page";
    }
    @GetMapping("/student")                          //only Student
    public String studentPage(){
        return "This is student Page";
    }
    @GetMapping("/faculty")
    public String facultyPage(){                //only faculty
        return "This is faculty Page";
    }

    @GetMapping("/library")                     //both
    public String libraryPage(){
        return "This is library Page";
    }

}
