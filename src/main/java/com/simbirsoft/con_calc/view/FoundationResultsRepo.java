package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.FoundationResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundationResultsRepo extends JpaRepository <FoundationResults, Long> {
}
