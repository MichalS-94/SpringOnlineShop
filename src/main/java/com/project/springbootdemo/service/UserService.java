package com.project.springbootdemo.service;

import com.project.springbootdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(){
        com.project.springbootdemo.model.User dupa = new com.project.springbootdemo.model.User();
        dupa.setName("Jan");
        dupa.setSurname("Kowalski");
        dupa.setLogin("KowalskiJ");
        dupa.setPassword("asd");

        userRepository.save(dupa);
    }

}
