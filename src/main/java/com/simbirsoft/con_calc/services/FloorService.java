package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.Hole;
import com.simbirsoft.con_calc.view.FloorRepo;
import com.simbirsoft.con_calc.view.HoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FloorService {

    final FloorRepo floorRepo;
    final HoleRepo holeRepo;

    public FloorService(FloorRepo floorRepo, HoleRepo holeRepo) {
        this.floorRepo = floorRepo;
        this.holeRepo = holeRepo;
    }

    public Floor findFloorById(Long id) {
        Optional<Floor> floorFromDb = floorRepo.findById(id);
        return floorFromDb.orElse(new Floor());
    }

    public void addFloor (Order order, Floor floor, Hole hole) {

        if(order.getFloors() == null || order.getFloors().isEmpty()) {
            floor.setIsFirst(true);
            floor.setNumber(1);
        }
        else {
            floor.setIsFirst(false);
            floor.setNumber(
                    (order
                            .getFloors()
                            .stream()
                            .map(Floor::getNumber)
                            .sorted()
                            .reduce((a, b) -> b)
                            .get()) + 1
            );
        }

        floor.setOrder(order);
        floorRepo.save(floor);

        hole.setFloor(floor);
        holeRepo.save(hole);
    }

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
