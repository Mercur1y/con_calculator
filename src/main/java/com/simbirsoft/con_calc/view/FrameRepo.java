package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Frame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameRepo extends JpaRepository<Frame, Long> {
}
