package com.biss.service;

import java.util.List;
import java.util.Optional;

import com.biss.model.Student;

public interface IStudentService {
	Integer saveStudent(Student s);
	List<Student> getAllStudent();
	
	Optional<Student> getOneStudent(Integer id);
	boolean isExist(Integer id);
	void deleteStudent(Integer id);
}
