package com.codingdojo.habits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController{
	
@GetMapping("/")
    public String loginPage() {
        return "login.jsp";
    }

@GetMapping("/register")
public String registerPage() {
    return "Register.jsp";
}

}