package com.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.school.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school.repository.StudentRepository;
import com.school.dao.Student;

import javax.validation.Valid;

@CrossOrigin(origins ={ "http://localhost:4200","http://10.3.30.141:4200"})
@RestController
@RequestMapping("/student")
public class StudentController {

    /*
    Service which will do all data
    retrieval/manipulation work
    */
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;
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
        for (long i = 40; i < 90; i++) {
            Student s = new Student();
            long c = (long) r.nextInt();
            s.setAge((int) c);
            s.setRollNo(c);
            s.setFirstName("lucky" + c);
            studentRepository.save(s);
        }
        return new ResponseEntity<String>("insertion Sucessfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/createstudent", consumes = {"application/json"}, produces = {
            "application/json"}, method = RequestMethod.POST)
    public ResponseEntity<String> insertStudents(@Valid @RequestBody com.school.model.Student student) {
        System.out.println("Inside create" + student.getAge());
        String res = studentService.saveStudent(student);
        return new ResponseEntity<String>(res, HttpStatus.OK);
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

    // you can also use imports, for example:
    // import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");


}
