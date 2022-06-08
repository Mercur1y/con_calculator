package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Set<Customer> findAllByIdIn(Set<Long> ids);
}
