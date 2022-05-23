package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepo extends JpaRepository<Floor, Long> {
}
