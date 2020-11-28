package com.project.springbootdemo;

import com.project.springbootdemo.configuration.SpringConfig;
import com.project.springbootdemo.model.dto.UserDTO;
import com.project.springbootdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

    public static void main(String[] args) { SpringApplication.run(SpringbootdemoApplication.class, args);
        System.out.println("Test");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.saveUser();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setLogin("Piotr");
//        userService.addUser(userDTO);
    }
}
