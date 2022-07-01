package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleCreationDto;
import com.simbirsoft.con_calc.dto.user.UserEditDto;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.Hole;
import com.simbirsoft.con_calc.mapper.FloorMapper;
import com.simbirsoft.con_calc.mapper.HoleMapper;
import com.simbirsoft.con_calc.view.FloorRepo;
import com.simbirsoft.con_calc.view.HoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FloorService {

    private final FloorRepo floorRepo;
    private final HoleRepo holeRepo;

    private final FloorMapper floorMapper;
    private final HoleMapper holeMapper;

    public Floor findFloorById(Long id) {
        Optional<Floor> floorFromDb = floorRepo.findById(id);
        return floorFromDb.orElse(new Floor());
    }

    public FloorEditDto getForEdit(Long id) {
        return floorMapper.toEditDto(findFloorById(id));
    }

    public Floor addFloor (Order order, FloorCreationDto floor, HoleCreationDto hole) {

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

        Floor floorEntity = floorMapper.toCreationEntity(floor);
        floorEntity.setOrder(order);
        floorRepo.save(floorEntity);

        Hole holeEntity = holeMapper.toCreationEntity(hole);
        holeEntity.setFloor(floorEntity);
        holeRepo.save(holeEntity);
        return floorEntity;
    }

    public void updateFloor(FloorEditDto floor, Long id) {
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
