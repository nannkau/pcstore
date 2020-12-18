package edu.sgu.store.service;

import edu.sgu.store.dto.CustomerDTO;
import edu.sgu.store.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
     Customer save(CustomerDTO customerDTO);
     Optional<Customer> findByUserName(String username);
}
