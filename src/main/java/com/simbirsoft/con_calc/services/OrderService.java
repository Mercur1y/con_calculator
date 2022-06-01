package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.view.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    final OrderRepo orderRepo;

    final CustomerService customerService;

    public OrderService(OrderRepo orderRepo, CustomerService customerService) {
        this.orderRepo = orderRepo;
        this.customerService = customerService;
    }

    public Order findOrderById(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        return order.orElse(new Order());
    }

    public Order addGetOrder(Long orderId, Long customerId, String adress) {

        Order order;

        if(orderId == null) {
            order = new Order();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy");
            order.setLocalDateTime(formatForDateNow.format(dateNow));
            Customer customer = customerService.findCustomerById(customerId);
            order.setAdress(adress);
            order.setCustomer(customer);
            orderRepo.save(order);
        }
        else order = orderRepo.getById(orderId);
        return order;
    }
}
