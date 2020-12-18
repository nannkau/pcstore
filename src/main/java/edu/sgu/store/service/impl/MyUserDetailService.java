package edu.sgu.store.service.impl;

import edu.sgu.store.dto.MyUserDetail;
import edu.sgu.store.entity.Customer;
import edu.sgu.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService  implements UserDetailsService {
    @Autowired
    final private CustomerRepository customerRepository;

    public MyUserDetailService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer=customerRepository.findByUsername(username).get();
        return new MyUserDetail(customer);
    }
}
