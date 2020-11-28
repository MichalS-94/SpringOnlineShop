package com.project.springbootdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String street;
    @Column(name = "zip_code")
    private String zipCode;
    private String number;

    @OneToOne(mappedBy = "address")
    private User userr;


}
