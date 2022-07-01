package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.order.OrderListDto;
import com.simbirsoft.con_calc.dto.customer.CustomerCreationDto;
import com.simbirsoft.con_calc.dto.customer.CustomerEditDto;
import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.mapper.CustomerMapper;
import com.simbirsoft.con_calc.mapper.OrderMapper;
import com.simbirsoft.con_calc.view.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;

    public Customer findCustomerById(Long customerId) {
        Optional<Customer> customerFromDb = customerRepo.findById(customerId);
        return customerFromDb.orElse(new Customer());
    }

    public CustomerEditDto getForEdit(Long id) {
        return customerMapper.toEditDto(findCustomerById(id));
    }

    public Set<OrderListDto> getDtoOrdersByCustomerId(Long id) {
        Customer customer = findCustomerById(id);
        return customer.getOrders().stream().map(orderMapper::toListDto).collect(Collectors.toSet());
    }

    public void addCustomerToUser(CustomerCreationDto customer, User user) {

        Customer customerEntity = customerMapper.toCreationEntity(customer);
        customerEntity.setUser(user);
        customerRepo.save(customerEntity);
    }

    public void updateCustomer(CustomerEditDto customer, Long id) {
        Customer customerFromDb = customerRepo.getById(id);
        customerFromDb.setLastName(customer.getLastName());
        customerFromDb.setFirstName(customer.getFirstName());
        customerFromDb.setSecondName(customer.getSecondName());
        customerFromDb.setEmail(customer.getEmail());
        customerFromDb.setPhone(customer.getPhone());
        customerFromDb.setAdress(customer.getAdress());
        customerFromDb.setUser(customerFromDb.getUser());
        customerRepo.save(customerFromDb);
    }
}
