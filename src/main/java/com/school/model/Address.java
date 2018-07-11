package com.school.model;


import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Address {

    /**
     * Address line 1
     **/

    private String addressLine1 = null;

    /**
     * Address line 2
     **/

    private String addressLine2 = null;

    /**
     * Customer's City Name
     **/

    private String cityName = null;

    /**
     * Customer's stateNameName province code (e.g OH)
     **/

    private String stateName = null;

    /**
     * Customer's postal code
     **/

    private String postalCode = null;

    /**
     * Customer's country name
     **/

    private String countryName = null;

    /**
     * Indicates the validation status of the address (VALIDATED, VERIFIED,
     * NOT_VERIFIED, ACCEPT)
     **/

    private String verificationStatus = null;

    /**
     * Type of Address
     **/

    private String typeOfAddress = null;


}

