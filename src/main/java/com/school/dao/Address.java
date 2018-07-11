package com.school.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "address")
public class Address {
    @Id
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String cityName;
    private String stateName;
    private String postalCode;
    private String countryName;
    private String verificationStatus;
    private String typeOfAddress;
    private Long studentId;
}
