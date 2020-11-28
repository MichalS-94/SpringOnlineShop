package com.project.springbootdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "userr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String login;
    private String password;


    @OneToMany(mappedBy = "userr", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Auction> auctions = new ArrayList<>();

    @OneToOne
    private Address address;

    @OneToOne
    private Bucket bucket;

}
