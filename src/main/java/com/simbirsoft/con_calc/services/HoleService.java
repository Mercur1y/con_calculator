package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Hole;
import com.simbirsoft.con_calc.view.HoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoleService {

    @Autowired
    HoleRepo holeRepo;

    public void updateHole (Hole hole, Long id) {
        Hole holeFromDB = holeRepo.getById(id);
        holeFromDB.setWidth(hole.getWidth());
        holeFromDB.setHeight(hole.getHeight());
        holeFromDB.setCount(hole.getCount());
        holeRepo.save(holeFromDB);
    }
}
