package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialTypeRepo extends JpaRepository<MaterialType, Long> {
    MaterialType findByName(String name);
}
