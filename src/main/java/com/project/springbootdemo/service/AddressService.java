package com.project.springbootdemo.service;

import com.project.springbootdemo.model.Address;
import com.project.springbootdemo.model.User;
import com.project.springbootdemo.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddress (){
        Address address1 = new Address();
        address1.setCountry("Poland");
        address1.setCity("Krakow");
        address1.setStreet("Grodzka");
        address1.setZipCode("10-100");
        address1.setNumber("31/15");
        addressRepository.save(address1);
    }

//    public void addAddress(Address address, User user){
//        user.setAddress(address);
//
//    }
}
