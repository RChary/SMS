package com.school.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.school.student.Student;

@Component
public interface StudentRepository extends MongoRepository<Student, Long> {
	
	Student findById(long id);
	Student findByRollNo(long rollNo);
	List<Student> findAll();
}