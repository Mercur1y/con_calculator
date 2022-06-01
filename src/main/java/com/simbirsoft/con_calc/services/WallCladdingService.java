package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.WallCladding;
import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;
import com.simbirsoft.con_calc.view.FloorRepo;
import com.simbirsoft.con_calc.view.FoundationRepo;
import com.simbirsoft.con_calc.view.MaterialRepo;
import com.simbirsoft.con_calc.view.WallCladdingRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WallCladdingService {

    private final WallCladdingRepo wallCladdingRepo;
    private final FloorRepo floorRepo;
    private final FoundationRepo foundationRepo;
    private final MaterialRepo materialRepo;

    public WallCladdingService(WallCladdingRepo wallCladdingRepo, FloorRepo floorRepo, FoundationRepo foundationRepo, MaterialRepo materialRepo) {
        this.wallCladdingRepo = wallCladdingRepo;
        this.floorRepo = floorRepo;
        this.foundationRepo = foundationRepo;
        this.materialRepo = materialRepo;
    }

    public WallCladding findWallCladdingById(Long id) {
        Optional<WallCladding> wallCladding = wallCladdingRepo.findById(id);
        return wallCladding.orElse(new WallCladding());
    }

    private boolean existsFloorByType(Floor floor, WallCladdingTypeEnum type) {
        if (floor.getWallCladdings() == null) return false;
        else return floor.getWallCladdings()
                .stream()
                .anyMatch(c -> c.getType().equals(type));
    }

    private boolean existsFoundation(Foundation foundation) {
        if (foundation.getWallCladdings() == null) return false;
        else return foundation.getWallCladdings()
                .stream()
                .anyMatch(c -> c.getType().equals(WallCladdingTypeEnum.OVERLAP));
    }

    private Long getIdFloorByType(Floor floor, WallCladdingTypeEnum type) {
        return floor.getWallCladdings()
                .stream()
                .filter(c -> c.getType().equals(type))
                .map(WallCladding::getId)
                .findFirst()
                .get();
    }

    private Long getFoundationId(Foundation foundation) {
        return foundation.getWallCladdings()
                .stream()
                .filter(c -> c.getType().equals(WallCladdingTypeEnum.OVERLAP))
                .map(WallCladding::getId)
                .findFirst()
                .get();
    }

    public void addOutWallCladding(String outOsbName,
                                   String outWaterName,
                                   String outWindName,
                                   String outWarmName,
                                   Long floorId
    ) {
        WallCladding outWallCladding;

        Floor floor = floorRepo.getById(floorId);
        boolean exists = existsFloorByType(floor, WallCladdingTypeEnum.OUT);

        if (!exists) {
            outWallCladding = new WallCladding();
            outWallCladding.setType(WallCladdingTypeEnum.OUT);
        }
        else {
            long id = getIdFloorByType(floor, WallCladdingTypeEnum.OUT);
            outWallCladding = wallCladdingRepo.getById(id);
        }

        outWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidthAndHeight(
                                3000, floor.getOutWallWidth(), 50),
                        materialRepo.getByName(outOsbName),
                        materialRepo.getByName(outWaterName),
                        materialRepo.getByName(outWindName),
                        materialRepo.getByName(outWarmName))
                        .collect(Collectors.toSet()));
        outWallCladding.setFloor(floor);
        wallCladdingRepo.save(outWallCladding);
    }

    public void addInWallCladding(String inOsbName,
                                  Long floorId
    ) {
        WallCladding inWallCladding;
        Floor floor = floorRepo.getById(floorId);
        boolean exists = existsFloorByType(floor, WallCladdingTypeEnum.IN);
        if(!exists) {
            inWallCladding = new WallCladding();
            inWallCladding.setType(WallCladdingTypeEnum.IN);
        } else {
            long id = getIdFloorByType(floor, WallCladdingTypeEnum.IN);
            inWallCladding = findWallCladdingById(id);
        }

        inWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidthAndHeight(
                                3000, floor.getInWallWidth(), 50),
                        materialRepo.getByName(inOsbName))
                        .collect(Collectors.toSet()));
        inWallCladding.setFloor(floor);
        wallCladdingRepo.save(inWallCladding);
    }

    public void addOverWallCladding (String overOsbName,
                                     String overWaterName,
                                     String overWindName,
                                     String overWarmName,
                                     Long floorId
    ) {
        WallCladding overWallCladding;

        Floor floor = floorRepo.getById(floorId);
        boolean exists = existsFloorByType(floor, WallCladdingTypeEnum.OVERLAP);

        if(!exists) {
            overWallCladding = new WallCladding();
            overWallCladding.setType(WallCladdingTypeEnum.OVERLAP);
        } else {
            long id = getIdFloorByType(floor, WallCladdingTypeEnum.OVERLAP);
            overWallCladding = findWallCladdingById(id);
        }

        overWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidthAndHeight(
                                6000, floor.getOverWidth(), 50),
                        materialRepo.getByName(overOsbName),
                        materialRepo.getByName(overWaterName),
                        materialRepo.getByName(overWindName),
                        materialRepo.getByName(overWarmName))
                        .collect(Collectors.toSet()));
        overWallCladding.setFloor(floor);
        wallCladdingRepo.save(overWallCladding);
    }

    public void addFoundationMaterials (
            String pilesName,
            String concreteName,
            Long foundationId
    ) {
        WallCladding foundMaterials;

        Foundation foundation = foundationRepo.getById(foundationId);
        boolean exists = existsFoundation(foundation);

        if(!exists) {
            foundMaterials = new WallCladding();
            foundMaterials.setType(WallCladdingTypeEnum.OVERLAP);
        } else {
            long id = getFoundationId(foundation);
            foundMaterials = findWallCladdingById(id);
        }

        foundMaterials
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidthAndHeight(
                                3000, 100, 30),
                        materialRepo.getByLengthAndWidthAndHeight(
                                3000, 50, 50),
                        materialRepo.getByWidth(14),
                        materialRepo.getByWidth(8),
                        materialRepo.getByName(pilesName),
                        materialRepo.getByName(concreteName))
                        .collect(Collectors.toSet()));
        foundMaterials.setFoundation(foundation);
        wallCladdingRepo.save(foundMaterials);
    }
}
