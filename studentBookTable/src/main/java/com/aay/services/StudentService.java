package com.aay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aay.entities.student;
import com.aay.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository repo;
    
	/*
	 * public student saveStudent(student s) {
	 * 
	 * if (s.getBooks() != null) { s.getBooks().forEach(book -> {
	 * book.setStudent(s); }); }
	 * 
	 * return repo.save(s);
	
    } */

	
	  public student saveStudent(student s) { return repo.save(s); }
	 

    public List<student> getAllStudents() {
        return repo.findAll();
    }
}