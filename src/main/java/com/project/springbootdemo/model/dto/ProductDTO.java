package com.project.springbootdemo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private long id;
    private String name;
    private String category;
    private double price;
}
