package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class LoginController {


    @GetMapping("login")
    public String getFormLogin() {
        return "login";
    }

    @PostMapping("login")
    public String login(
            @RequestParam("user") String user,
            @RequestParam("pass") String pass,
            Model model
    ) {
        System.out.println(user);
        System.out.println(pass);
        model.addAttribute("name",user);
        return "login";
    }
}
