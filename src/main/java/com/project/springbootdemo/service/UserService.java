package com.project.springbootdemo.service;

import com.project.springbootdemo.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(){
        com.project.springbootdemo.model.User user1 = new com.project.springbootdemo.model.User();
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setLogin("KowalskiJ");
        user1.setPassword("asd");
        userRepository.save(user1);
    }

    public void removeUser(Long id){
        userRepository.deleteById(id);
    }

}
