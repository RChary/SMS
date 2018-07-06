package com.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.repository.StudentRepository;
import com.school.student.Student;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository; // Service which will do all data
											// retrieval/manipulation work

	List<Student> allStudents = new ArrayList<>();

	@RequestMapping(value = "/allStudents", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllStudents() {
		List<Student> students = studentRepository.findAll();
		if (students.isEmpty()) {
			insertStudents();
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent(@RequestParam String id) {
		Student students = studentRepository.findById(Long.parseLong(id));
		return new ResponseEntity(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/insertStudents", method = RequestMethod.GET)
	public ResponseEntity<String> insertStudents() {

		Random r = new Random();
		for (int i = 40; i < 90; i++) {
			Student s = new Student();
			int c = r.nextInt();
			s.setId(c);
			s.setAge(21 + c);
			s.setRollNo(c);
			s.setFirstName("lucky" + c);
			studentRepository.save(s);
		}
		return new ResponseEntity<String>("insertion Sucessfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Student saveUser(@RequestBody Student student) {
		if (student.getId() == 0 || StringUtils.isEmpty(String.valueOf(student.getId()))) {
			Random r = new Random();
			student.setId(r.nextInt());
		}
		studentRepository.save(student);
		return student;

	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
	public void deleteStudent(@RequestParam String id) {
		studentRepository.delete(Long.parseLong(id));
	}
	
	

}
