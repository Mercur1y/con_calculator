package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Material;
import com.simbirsoft.con_calc.entity.Roof;
import com.simbirsoft.con_calc.entity.RoofResults;
import com.simbirsoft.con_calc.view.MaterialRepo;
import com.simbirsoft.con_calc.view.RoofResultsRepo;
import com.simbirsoft.con_calc.view.WallCladdingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoofResultsService {

    private final RoofResultsRepo roofResultsRepo;
    private final WallCladdingRepo wallCladdingRepo;
    private final  CalculationService calculationService;
    private final MaterialService materialService;

    public void addUpdateResults (Roof roof) {

        RoofResults roofResults;
        int type = roof.getType();

        if (roof.getRoofResults() == null) {
            roofResults = new RoofResults();
        }
        else {
            roofResults = roofResultsRepo.getById(roof.getRoofResults().getId());
        }

        Set<Material> materials = wallCladdingRepo.getByRoof(roof).getMaterials();

        double volumeOfRaftersWood = calculationService.getVolumeOfRafters(roof, type);
        Material raft = materialService.getByTypeIdAndWidth(materials, 1L, 200);
        roofResults.setNameOfRaftersWood(raft.getName());
        roofResults.setVolumeOfRaftersWood(volumeOfRaftersWood);
        roofResults.setPriceOfRaftersWood(calculationService.round(volumeOfRaftersWood * raft.getPrice()));

        double volumeOfLathWood = calculationService.getVolumeOfLathWood(roof);
        Material lath = materialService.getByTypeIdAndWidth(materials, 1L, 100);
        roofResults.setNameOfLathWood(lath.getName());
        roofResults.setVolumeOfLathWood(volumeOfLathWood);
        roofResults.setPriceOfLathWood(calculationService.round(volumeOfLathWood * lath.getPrice()));

        double squareOfWater = calculationService.getSquareOfWater(roof, type);
        Material water = materialService.getByTypeId(materials, 4L);
        roofResults.setNameOfWater(water.getName());
        roofResults.setSquareOfWater(squareOfWater);
        roofResults.setPriceOfWater(calculationService.round(squareOfWater * water.getPrice()));

        double volumeOfWarm = calculationService.getVolumeOfWarm(roof, type);
        Material warm = materialService.getByTypeId(materials, 3L);
        roofResults.setNameOfWarm(warm.getName());
        roofResults.setVolumeOfWarm(volumeOfWarm);
        roofResults.setPriceOfWarm(calculationService.round(volumeOfWarm * warm.getPrice()));

        double squareOfTop = calculationService.getSquareOfTop(roof, type);
        Material top = materialService.getByTypeId(materials, 9L);
        roofResults.setNameOfTop(top.getName());
        roofResults.setSquareOfTop(squareOfTop);
        roofResults.setPriceOfTop(calculationService.round(squareOfTop * top.getPrice()));

        roofResults.setTotalPriceOfFrame(
                roofResults.getPriceOfLathWood() + roofResults.getPriceOfRaftersWood()
        );

        roofResults.setTotalPriceOfCover(
                roofResults.getPriceOfWarm() + roofResults.getPriceOfWater()
        );

        roofResults.setTotalPriceOfTop(
                roofResults.getPriceOfTop()
        );

        roofResults.setTotalPrice(
                roofResults.getTotalPriceOfFrame()
                + roofResults.getTotalPriceOfCover()
                + roofResults.getTotalPriceOfTop()
        );

        roofResults.setRoof(roof);
        roofResultsRepo.save(roofResults);
    }
}
