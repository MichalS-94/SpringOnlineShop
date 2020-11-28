package com.project.springbootdemo.service;

import com.project.springbootdemo.model.Address;
import com.project.springbootdemo.model.Auction;
import com.project.springbootdemo.model.Product;
import com.project.springbootdemo.model.User;
import com.project.springbootdemo.model.dto.UserDTO;
import com.project.springbootdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void saveUser(){
        Product product1 = new Product();
        product1.setName("Toyota Yaris");
        product1.setCategory("Cars");
        product1.setPrice(10000);

        Product product2 = new Product();
        product2.setName("T shirt");
        product2.setCategory("Clothes");
        product2.setPrice(50);

        Auction auction1 = new Auction();
        auction1.setType("auction");
        auction1.setProduct(product1);

        Auction auction2 = new Auction();
        auction2.setType("Buy now");
        auction2.setProduct(product2);

        List<Auction> auctionList = new ArrayList<>();
        auctionList.add(auction1);
        auctionList.add(auction2);

        Address address1 = new Address();
        address1.setCountry("Poland");
        address1.setCity("Krakow");
        address1.setStreet("Grodzka");
        address1.setZipCode("10-100");
        address1.setNumber("31/15");

        User user1 = new User();
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setLogin("KowalskiJ");
        user1.setPassword("asd");
        user1.setAddress(address1);
        user1.setAuctions(auctionList);
        userRepository.save(user1);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public void removeUser(Long id){
        userRepository.deleteById(id);
    }

    public void removeAllUsers(){
        userRepository.deleteAll();
    }

}
