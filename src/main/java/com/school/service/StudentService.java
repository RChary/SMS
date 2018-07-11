package com.school.service;

import com.school.model.Address;
import com.school.model.Student;

public interface StudentService {
	String saveStudent(Student student);
	String saveAddress(Address address, String type, Long studentId);
}
