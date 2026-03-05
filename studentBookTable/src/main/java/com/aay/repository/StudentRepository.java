package com.aay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aay.entities.student;

public interface StudentRepository extends JpaRepository<student, Long> {

}