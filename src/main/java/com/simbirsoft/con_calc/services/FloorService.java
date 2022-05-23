package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.view.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FloorService {

    @Autowired
    FloorRepo floorRepo;

    public Floor findFloorById(Long id) {
        Optional<Floor> floor = floorRepo.findById(id);
        return floor.orElse(new Floor());
    }
}
