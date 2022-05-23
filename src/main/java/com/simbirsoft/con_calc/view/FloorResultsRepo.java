package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.FloorResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorResultsRepo extends JpaRepository<FloorResults, Long> {
}
