package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Hole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoleRepo extends JpaRepository<Hole, Long> {

}
