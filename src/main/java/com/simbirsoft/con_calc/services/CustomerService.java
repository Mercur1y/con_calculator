package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.view.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    public Customer findCustomerById(Long customerId) {
        Optional<Customer> customerFromDb = customerRepo.findById(customerId);
        return customerFromDb.orElse(new Customer());
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Customer customer, Long id) {
        Customer customerFromDb = customerRepo.getById(id);
        customerFromDb.setLast_name(customer.getLast_name());
        customerFromDb.setFirst_name(customer.getFirst_name());
        customerFromDb.setSecond_name(customer.getSecond_name());
        customerFromDb.setEmail(customer.getEmail());
        customerFromDb.setPhone(customer.getPhone());
        customerFromDb.setAdress(customer.getAdress());
        customerFromDb.setUser(customerFromDb.getUser());
        customerRepo.save(customerFromDb);
    }
}
