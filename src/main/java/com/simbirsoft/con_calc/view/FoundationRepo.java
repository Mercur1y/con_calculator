package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Foundation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundationRepo extends JpaRepository<Foundation, Long> {
}
