package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Customer;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.view.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final CustomerService customerService;

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
            order.setStatus("Создан");
            orderRepo.save(order);
        }
        else order = orderRepo.getById(orderId);
        return order;
    }

    public void updateStatus(Long orderId, String status) {
        Order order = findOrderById(orderId);
        order.setStatus(status);
        orderRepo.save(order);
    }
}
