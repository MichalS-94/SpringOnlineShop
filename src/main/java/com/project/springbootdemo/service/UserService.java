package com.project.springbootdemo.service;

import com.project.springbootdemo.model.*;
import com.project.springbootdemo.model.dto.AddressDTO;
import com.project.springbootdemo.model.dto.ProductDTO;
import com.project.springbootdemo.model.dto.UserDTO;
import com.project.springbootdemo.repository.ProductRepository;
import com.project.springbootdemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private ProductRepository productRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
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
        user1.setPassword(passwordEncoder.encode("asd"));
        user1.setEmail("kowalskij@gmail.com");
        user1.setAddress(address1);

        Auction auction1 = new Auction();
        auction1.setType("auction");
        auction1.setProduct(product1);
        auction1.setUserr(user1);

        Auction auction2 = new Auction();
        auction2.setType("Buy now");
        auction2.setProduct(product2);
        auction2.setUserr(user1);

        List<Auction> auctionList = new ArrayList<>();
        auctionList.add(auction1);
        auctionList.add(auction2);

        user1.setAuctions(auctionList);

        Bucket bucket = new Bucket();
        bucket.setUserr(user1);
        bucket.setAuctionsInBucket(auctionList);

        user1.setBucket(bucket);

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

    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void removeUser(Long id){
        userRepository.deleteById(id);
    }

    public void removeAllUsers(){
        userRepository.deleteAll();
    }

    public void addUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setLogin(userDTO.getLogin());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
//        Address address = modelMapper.map(addressDTO, Address.class);
//        address.setNumber(addressDTO.getNumber());
//        address.setZipCode(addressDTO.getZipCode());
//        address.setStreet(addressDTO.getStreet());
//        address.setCity(addressDTO.getCity());
//        user.setAddress(address);
        userRepository.save(user);
    }

}
