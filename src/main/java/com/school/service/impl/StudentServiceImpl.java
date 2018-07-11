package com.school.service.impl;

import com.school.model.Address;
import com.school.model.Student;
import com.school.repository.AddressRepository;
import com.school.repository.StudentRepository;
import com.school.service.StudentService;
import com.school.util.Constants;
import com.school.util.DBServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public String saveStudent(Student student) {
        if(studentRepository.findByRollNo(Long.parseLong(student.getRollNo())) == null){
            com.school.dao.Student stud = DBServiceHelper.getStudent(student);
            studentRepository.save(stud);
            saveAddress(student.getPermenentAddress(),Constants.PERMENENT_ADDRESS,stud.getId());
            saveAddress(student.getPresentAddress(),Constants.PRESENT_ADDRESS,stud.getId());
            return "insertion Sucessfully";
        }else{
            return "Record already exisist with above RollNo";
        }
    }

    @Override
    public String saveAddress(Address address, String type, Long studentId) {
        addressRepository.save(DBServiceHelper.getAddress(address,type,studentId));
        return null;
    }

}
