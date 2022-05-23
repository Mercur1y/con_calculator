package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.WallCladding;
import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;
import com.simbirsoft.con_calc.view.MaterialRepo;
import com.simbirsoft.con_calc.view.WallCladdingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WallCladdingService {

    @Autowired
    private WallCladdingRepo wallCladdingRepo;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialRepo materialRepo;

    public WallCladding findWallCladdingById(Long id) {
        Optional<WallCladding> wallCladding = wallCladdingRepo.findById(id);
        return wallCladding.orElse(new WallCladding());
    }

    public void addOutWallCladding(Long outOsbId,
                                   Long outWaterId,
                                   Long outWindId,
                                   Long outWarmId,
                                   Floor floor
    ) {
        WallCladding outWallCladding = new WallCladding();
        outWallCladding.setType(WallCladdingTypeEnum.OUT);
        outWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidth(
                                (short) 3000, floor.getOutWallWidth()),
                        materialService.findMaterialById(outOsbId),
                        materialService.findMaterialById(outWaterId),
                        materialService.findMaterialById(outWindId),
                        materialService.findMaterialById(outWarmId))
                        .collect(Collectors.toSet()));
        outWallCladding.setFloor(floor);
        wallCladdingRepo.save(outWallCladding);
    }

    public void addInWallCladding(Long inOsbId,
                                   Floor floor
    ) {
        WallCladding inWallCladding = new WallCladding();
        inWallCladding.setType(WallCladdingTypeEnum.IN);
        inWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidth
                                ((short) 3000, floor.getInWallWidth()),
                        materialService.findMaterialById(inOsbId))
                        .collect(Collectors.toSet()));
        inWallCladding.setFloor(floor);
        wallCladdingRepo.save(inWallCladding);
    }

    public void addOverWallCladding(Long overOsbId,
                                   Long overWaterId,
                                   Long overWindId,
                                   Long overWarmId,
                                   Floor floor
    ) {
        WallCladding overWallCladding = new WallCladding();
        overWallCladding.setType(WallCladdingTypeEnum.OVERLAP);
        overWallCladding
                .setMaterials(Stream.of(
                        materialRepo.getByLengthAndWidth
                                ((short) 6000, floor.getOverWidth()),
                        materialService.findMaterialById(overOsbId),
                        materialService.findMaterialById(overWaterId),
                        materialService.findMaterialById(overWindId),
                        materialService.findMaterialById(overWarmId))
                        .collect(Collectors.toSet()));
        overWallCladding.setFloor(floor);
        wallCladdingRepo.save(overWallCladding);
    }
}
