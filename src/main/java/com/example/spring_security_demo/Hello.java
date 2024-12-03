package com.example.spring_security_demo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        return "Hello World " + request.getSession().getId();    // Session id
    }

    @GetMapping("/about")
    public String about(){
        return "Ruchika";
    }
}
