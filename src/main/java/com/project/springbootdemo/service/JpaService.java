package com.project.springbootdemo.service;

import com.project.springbootdemo.configuration.JpaConfig;
import com.project.springbootdemo.model.jpa.Address;
import com.project.springbootdemo.model.jpa.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class JpaService {
    private EntityManager entityManager;

    public JpaService (JpaConfig jpaConfig){
        entityManager = jpaConfig.getEntityManager();
    }

    public User prepareUser(){
        User user = new User();

        Address address1 = new Address();
        address1.setCity("Krakow");
        address1.setCountry("Poland");
        address1.setStreet("Grodzka");
        address1.setZipCode("31-210");
        address1.setNumber("45/10");

        user.setLogin("KowalskiJ");
        user.setName("Jan");
        user.setSurname("Kowalski");
        user.setPassword("password");
        user.setAddress(address1);

        return user;
    }
}
