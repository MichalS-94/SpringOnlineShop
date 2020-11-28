package com.project.springbootdemo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String password;

}
