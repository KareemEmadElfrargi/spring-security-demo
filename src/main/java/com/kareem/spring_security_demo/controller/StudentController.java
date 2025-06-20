package com.kareem.spring_security_demo.controller;


import com.kareem.spring_security_demo.model.Student;
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
            new Student(1, "Kareem", "Java"),
            new Student(2, "Ahmed", "Python"),
            new Student(3, "Ali", "JavaScript"),
            new Student(4, "Sara", "C#")
    ));

    // Method to get the Token
    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        System.out.println("Adding student: " + student.getName());
        students.add(student);
    }
}
