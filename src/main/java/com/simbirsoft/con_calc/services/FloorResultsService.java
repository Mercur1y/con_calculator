package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.Material;
import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;
import com.simbirsoft.con_calc.view.FloorResultsRepo;
import com.simbirsoft.con_calc.view.WallCladdingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class FloorResultsService {

    @Autowired
    WallCladdingRepo wallCladdingRepo;

    @Autowired
    FloorResultsRepo floorResultsRepo;

    @Autowired
    CalculationService calculationService;

    @Autowired
    MaterialService materialService;

    public FloorResults findFloorResultsById(Long id) {
        Optional<FloorResults> resultsFromDb = floorResultsRepo.findById(id);
        return resultsFromDb.orElse(new FloorResults());
    }

    public void addUpdateResults (Floor floor) {

        FloorResults floorResults;

        if(floor.getFloorResults() == null) floorResults = new FloorResults();
        else {
            floorResults = floorResultsRepo.getById(floor.getFloorResults().getId());
        }

        Set<Material> outMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.OUT).getMaterials();
        Set<Material> inMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.IN).getMaterials();
        Set<Material> overMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.OVERLAP).getMaterials();

        //-----------------------------------------------
        //Для внешних

        double volumeOfOutWood = calculationService.getWallVolumeOfWood(floor, "out");
        floorResults.setNameOfOutWood(materialService.getNameByTypeId(outMaterials, 1L));
        floorResults.setVolumeOfOutWood(volumeOfOutWood);
        floorResults.setPriceOfOutWood(calculationService.round(volumeOfOutWood * materialService.getPriceByTypeId(outMaterials, 1L)));

        double squareOfOutOsb = calculationService.getWallOsbSquare(floor, "out");
        floorResults.setNameOfOutOsb(materialService.getNameByTypeId(outMaterials, 2L));
        floorResults.setSquareOfOutOsb(squareOfOutOsb);
        floorResults.setPriceOfOutOsb(calculationService.round(squareOfOutOsb * materialService.getPriceByTypeId(outMaterials, 2L)));

        double volumeOfOutWarm = calculationService.getOutVolumeOfWarm(floor);
        floorResults.setNameOfOutWarm(materialService.getNameByTypeId(outMaterials, 3L));
        floorResults.setVolumeOfOutWarm(volumeOfOutWarm);
        floorResults.setPriceOfOutWarm(calculationService.round(volumeOfOutWarm * materialService.getPriceByTypeId(outMaterials, 3L)));

        double squareOfOutWaterAndWind = calculationService.getOutWindAndWaterSquare(floor);
        floorResults.setNameOfOutWater(materialService.getNameByTypeId(outMaterials, 4L));
        floorResults.setSquareOfOutWater(squareOfOutWaterAndWind);
        floorResults.setPriceOfOutWater(calculationService.round(squareOfOutWaterAndWind * materialService.getPriceByTypeId(outMaterials, 4L)));

        floorResults.setNameOfOutWind(materialService.getNameByTypeId(outMaterials, 5L));
        floorResults.setSquareOfOutWind(squareOfOutWaterAndWind);
        floorResults.setPriceOfOutWind(calculationService.round(squareOfOutWaterAndWind * materialService.getPriceByTypeId(outMaterials, 5L)));

        //-----------------------------------------------
        //Для внутренних

        double volumeOfInWood = calculationService.getWallVolumeOfWood(floor, "in");
        floorResults.setNameOfInWood(materialService.getNameByTypeId(inMaterials, 1L));
        floorResults.setVolumeOfInWood(volumeOfInWood);
        floorResults.setPriceOfInWood(calculationService.round(volumeOfInWood * materialService.getPriceByTypeId(inMaterials, 1L)));

        double squareOfInOsb = calculationService.getWallOsbSquare(floor, "in");
        floorResults.setNameOfInOsb(materialService.getNameByTypeId(inMaterials, 2L));
        floorResults.setSquareOfInOsb(squareOfInOsb);
        floorResults.setPriceOfInOsb(squareOfInOsb * materialService.getPriceByTypeId(inMaterials, 2L));

        //-----------------------------------------------
        //Для перекрытий

        double volumeOfOverWood = calculationService.getOverVolumeOfWood(floor);
        floorResults.setNameOfOverWood(materialService.getNameByTypeId(overMaterials, 1L));
        floorResults.setVolumeOfOverWood(volumeOfOverWood);
        floorResults.setPriceOfOverWood(calculationService.round(volumeOfOverWood * materialService.getPriceByTypeId(overMaterials, 1L)));

        double squareOfOverOsb = calculationService.getOverOsbSquare(floor);
        floorResults.setNameOfOverOsb(materialService.getNameByTypeId(overMaterials, 2L));
        floorResults.setSquareOfOverOsb(squareOfOverOsb);
        floorResults.setPriceOfOverOsb(calculationService.round(squareOfOverOsb * materialService.getPriceByTypeId(overMaterials, 2L)));

        double volumeOfOverWarm = calculationService.getOverVolumeOfWarm(floor);
        floorResults.setNameOfOverWarm(materialService.getNameByTypeId(overMaterials, 3L));
        floorResults.setVolumeOfOverWarm(volumeOfOverWarm);
        floorResults.setPriceOfOverWarm(calculationService.round(volumeOfOverWarm * materialService.getPriceByTypeId(overMaterials, 3L)));

        double squareOfOverWaterAndWind = calculationService.getOverWindAndWaterSquare(floor);
        floorResults.setNameOfOverWater(materialService.getNameByTypeId(overMaterials, 4L));
        floorResults.setSquareOfOverWater(squareOfOverWaterAndWind);
        floorResults.setPriceOfOverWater(calculationService.round(squareOfOverWaterAndWind * materialService.getPriceByTypeId(overMaterials, 4L)));

        floorResults.setNameOfOverWind(materialService.getNameByTypeId(overMaterials, 5L));
        floorResults.setSquareOfOverWind(squareOfOverWaterAndWind);
        floorResults.setPriceOfOverWind(calculationService.round(squareOfOverWaterAndWind * materialService.getPriceByTypeId(overMaterials, 5L)));

        floorResults.setTotalOutPrice(
                        floorResults.getPriceOfOutWood()
                        + floorResults.getPriceOfOutWind()
                        + floorResults.getPriceOfOutOsb()
                        + floorResults.getPriceOfOutWarm()
                        + floorResults.getPriceOfOutWater()
        );

        floorResults.setTotalInPrice(
                        floorResults.getPriceOfInWood()
                        + floorResults.getPriceOfInOsb()
        );

        floorResults.setTotalOverPrice(
                        floorResults.getPriceOfOverWood()
                        + floorResults.getPriceOfOverWind()
                        + floorResults.getPriceOfOverOsb()
                        + floorResults.getPriceOfOverWarm()
                        + floorResults.getPriceOfOverWater()
        );

        floorResults.setTotalAllPrice(
                floorResults.getTotalOutPrice()
                + floorResults.getTotalInPrice()
                + floorResults.getTotalOverPrice()
        );

        floorResults.setFloor(floor);
        floorResultsRepo.save(floorResults);
    }
}
