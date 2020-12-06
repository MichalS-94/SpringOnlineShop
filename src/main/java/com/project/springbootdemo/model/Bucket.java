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
@Table(name = "bucket")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne
//    private User userr;

//    @OneToMany(mappedBy = "bucket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Auction> auctionss = new ArrayList<>();

}
