package com.example.spring_security_demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Navin", "Java"),
            new Student(2, "Raj", "C++"),
            new Student(3, "Sunny", "Python")
    ));

    // CSRF token is mendatory for POST, PUT and DELETE request to work,
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public String getStudents(HttpServletRequest request){
        return students + request.getSession().getId();
    }

    @PostMapping("students")
    public void addStudents(@RequestBody Student student){
        students.add(student);
    }

}
