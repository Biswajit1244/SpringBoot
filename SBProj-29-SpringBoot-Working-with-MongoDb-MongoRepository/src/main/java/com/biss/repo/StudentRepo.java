package com.biss.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.biss.model.Student;

public interface StudentRepo extends 
			MongoRepository<Student,Integer> {

}
