package com.biss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biss.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
