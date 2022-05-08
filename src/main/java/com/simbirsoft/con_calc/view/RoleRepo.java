package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
