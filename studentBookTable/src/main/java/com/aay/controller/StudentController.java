package com.aay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aay.entities.student;
import com.aay.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping
    public student createStudent(@RequestBody student s) {
        return service.saveStudent(s);
    }

    @GetMapping
    public List<student> getStudents() {
        return service.getAllStudents();
    }
}