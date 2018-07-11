package com.school.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;
/**
 * Student
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Student   {
    @JsonProperty("rollNo")
    @Size(max=3)
    private String rollNo = null;

    @JsonProperty("firstName")
    @Size(max=30)
    private String firstName = null;

    @JsonProperty("lastName")
    @Size(max=30)
    private String lastName = null;

    @JsonProperty("age")
    @Size(max=2)
    private String age = null;

    @JsonProperty("fatherName")
    @Size(max=30)
    private String fatherName = null;

    @JsonProperty("motherName")
    @Size(max=30)
    private String motherName = null;

    @JsonProperty("phoneNumber")
    @Size(max=10)
    //@Pattern(regexp = "[1-9]*", message="Phone Number must be digits")
    private String phoneNumber = null;

    @JsonProperty("email")
    @Size(max=50)
  //  @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email should be proper")
    private String email = null;

    @JsonProperty("presentAddress")
    @Valid
    private Address presentAddress;

    @JsonProperty("permenentAddress")
    @Valid
    private Address permenentAddress;


}

