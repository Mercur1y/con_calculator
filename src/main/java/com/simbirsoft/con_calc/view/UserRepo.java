package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
