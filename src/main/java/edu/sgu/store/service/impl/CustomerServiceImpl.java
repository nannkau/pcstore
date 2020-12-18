package edu.sgu.store.service.impl;

import edu.sgu.store.dto.CustomerDTO;
import edu.sgu.store.entity.Customer;
import edu.sgu.store.repository.CustomerRepository;
import edu.sgu.store.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    final private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        customer.setPasswork(passwordEncoder.encode(customerDTO.getPasswork()));
        customer.setJoinDate(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByUserName(String username) {
        return customerRepository.findByUsername(username);
    }
}
