package com.codegym.ums.controller;

import com.codegym.ums.model.User;
import com.codegym.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView listUser(@RequestParam("s") Optional<String> s, Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("list");

        Page<User> users;
        if(s.isPresent()){
            users = userService.findByFirstname(s.get(), pageable);
            modelAndView.addObject("s", s);
        } else{
            users = userService.findAll(pageable);
        }

        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "User created successfully");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


}
