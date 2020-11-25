package com.project.springbootdemo.model.jpa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String group;

    @OneToOne
    private Product product;

    @ManyToOne
    private User user;

    @ManyToOne
    private Bucket bucket;

}
