package com.project.springbootdemo.repository;

import com.project.springbootdemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
