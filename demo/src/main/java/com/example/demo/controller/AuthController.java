/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author dell
 */
@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "home";
        }
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
