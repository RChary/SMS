package com.school.dao;

import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Setter
@Document(collection = "student")
public class Student {
    @Id
    private long id;
    private long rollNo;
    private String firstName;
    private String lastName;
    private int age;
    private String fatherName;
    private String motherName;
    private String standard;
    private String secondaryContactNo;
    private String emergencyContactNo;
    private String primaryContactNo;
    private String email;
}
