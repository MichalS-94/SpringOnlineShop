package com.project.springbootdemo.service;

import com.project.springbootdemo.model.User;
import com.project.springbootdemo.model.dto.UserDTO;
import com.project.springbootdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserService(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    public void saveUser(){

    }

    public void addUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }
}
