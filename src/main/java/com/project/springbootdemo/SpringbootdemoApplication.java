package com.project.springbootdemo;

import com.project.springbootdemo.configuration.SpringConfig;
import com.project.springbootdemo.model.User;
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
//        userService.saveUser();
//        userService.removeUser(59L);
//        userService.removeAllUsers();
//        System.out.println(userService.getAllUsers());
//        System.out.println(userService.getUserById(1L));

//        AddressService addressService = context.getBean(AddressService.class);
//        addressService.saveAddress();
//        UserDTO userDTO = new UserDTO();
//        userDTO.setLogin("Piotr");
//        userService.addUser(userDTO);
    }
}
