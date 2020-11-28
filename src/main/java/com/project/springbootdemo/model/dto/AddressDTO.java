package com.project.springbootdemo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private long id;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private String number;
}
