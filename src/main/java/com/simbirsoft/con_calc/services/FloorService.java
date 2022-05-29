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

    public void updateFloor(Floor floor, Long id) {
        Floor floorFromDb = floorRepo.getById(id);
        floorFromDb.setInPerimeter(floor.getInPerimeter());
        floorFromDb.setOutPerimeter(floor.getOutPerimeter());
        floorFromDb.setHeight(floor.getHeight());
        floorFromDb.setInWallWidth(floor.getInWallWidth());
        floorFromDb.setOutWallWidth(floor.getOutWallWidth());
        floorFromDb.setOverWidth(floor.getOverWidth());
        floorFromDb.setSquare(floor.getSquare());
        floorRepo.save(floorFromDb);
    }
}
