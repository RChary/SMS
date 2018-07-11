package com.school.util;

import com.school.model.Address;
import com.school.model.Student;

public class DBServiceHelper {

    public static com.school.dao.Student getStudent(Student student){
        com.school.dao.Student stud = new com.school.dao.Student();
        stud.setId(DateUtil.getDate(Constants.DATE_TIME_PATTERN));
        stud.setAge(Integer.parseInt(student.getAge()));
        stud.setRollNo(Long.parseLong(student.getRollNo()));
        stud.setFirstName(student.getFirstName());
        stud.setLastName(student.getLastName());
        stud.setFatherName(student.getFatherName());
        stud.setMotherName(student.getMotherName());
        stud.setEmail(student.getEmail());
        stud.setPrimaryContactNo(student.getPhoneNumber());
        return stud;
    }
    public static com.school.dao.Address getAddress(Address address,String type,Long studentId){
        com.school.dao.Address addr = new com.school.dao.Address();
        addr.setId(DateUtil.getDate(Constants.DATE_TIME_PATTERN));
        addr.setAddressLine1(address.getAddressLine1());
        addr.setAddressLine2(address.getAddressLine2());
        addr.setCityName(address.getCityName());
        addr.setCountryName(address.getCountryName());
        addr.setPostalCode(address.getPostalCode());
        addr.setStateName(address.getStateName());
        addr.setVerificationStatus(address.getVerificationStatus());
        addr.setStudentId(studentId);
        addr.setTypeOfAddress(type);
        return addr;
    }
}
