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

    public FloorResults findFloorResultsById(Long id) {
        Optional<FloorResults> resultsFromDb = floorResultsRepo.findById(id);
        return resultsFromDb.orElse(new FloorResults());
    }

    private String getNameByTypeId (Set <Material> materials, Long id) {
       return  materials.stream()
               .filter(material -> material.getType().getId().equals(id))
               .map(Material::getName)
               .findFirst()
               .orElse(null);
    }

    private double getPriceByTypeId (Set <Material> materials, Long id) {
        return  materials.stream()
                .filter(material -> material.getType().getId().equals(id))
                .map(Material::getPrice)
                .findFirst()
                .orElse(null);
    }

    public void addUpdateResults (Floor floor) {
        FloorResults floorResults = new FloorResults();

        Set<Material> outMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.OUT).getMaterials();
        Set<Material> inMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.IN).getMaterials();
        Set<Material> overMaterials = wallCladdingRepo.findByFloorAndType(floor, WallCladdingTypeEnum.OVERLAP).getMaterials();

        //-----------------------------------------------
        //Для внешних

        double volumeOfOutWood = calculationService.getWallVolumeOfWood(floor, "out");
        floorResults.setNameOfOutWood(getNameByTypeId(outMaterials, 1L));
        floorResults.setVolumeOfOutWood(volumeOfOutWood);
        floorResults.setPriceOfOutWood(calculationService.round(volumeOfOutWood * getPriceByTypeId(outMaterials, 1L)));

        double squareOfOutOsb = calculationService.getWallOsbSquare(floor, "out");
        floorResults.setNameOfOutOsb(getNameByTypeId(outMaterials, 2L));
        floorResults.setSquareOfOutOsb(squareOfOutOsb);
        floorResults.setPriceOfOutOsb(calculationService.round(squareOfOutOsb * getPriceByTypeId(outMaterials, 2L)));

        double volumeOfOutWarm = calculationService.getOutVolumeOfWarm(floor);
        floorResults.setNameOfOutWarm(getNameByTypeId(outMaterials, 3L));
        floorResults.setVolumeOfOutWarm(volumeOfOutWarm);
        floorResults.setPriceOfOutWarm(calculationService.round(volumeOfOutWarm * getPriceByTypeId(outMaterials, 3L)));

        double squareOfOutWaterAndWind = calculationService.getOutWindAndWaterSquare(floor);
        floorResults.setNameOfOutWater(getNameByTypeId(outMaterials, 4L));
        floorResults.setSquareOfOutWater(squareOfOutWaterAndWind);
        floorResults.setPriceOfOutWater(calculationService.round(squareOfOutWaterAndWind * getPriceByTypeId(outMaterials, 4L)));

        floorResults.setNameOfOutWind(getNameByTypeId(outMaterials, 5L));
        floorResults.setSquareOfOutWind(squareOfOutWaterAndWind);
        floorResults.setPriceOfOutWind(calculationService.round(squareOfOutWaterAndWind * getPriceByTypeId(outMaterials, 5L)));

        //-----------------------------------------------
        //Для внутренних

        double volumeOfInWood = calculationService.getWallVolumeOfWood(floor, "in");
        floorResults.setNameOfInWood(getNameByTypeId(inMaterials, 1L));
        floorResults.setVolumeOfInWood(volumeOfInWood);
        floorResults.setPriceOfInWood(calculationService.round(volumeOfInWood * getPriceByTypeId(inMaterials, 1L)));

        double squareOfInOsb = calculationService.getWallOsbSquare(floor, "in");
        floorResults.setNameOfInOsb(getNameByTypeId(inMaterials, 2L));
        floorResults.setSquareOfInOsb(squareOfInOsb);
        floorResults.setPriceOfInOsb(squareOfInOsb * getPriceByTypeId(inMaterials, 2L));

        //-----------------------------------------------
        //Для перекрытий

        double volumeOfOverWood = calculationService.getOverVolumeOfWood(floor);
        floorResults.setNameOfOverWood(getNameByTypeId(overMaterials, 1L));
        floorResults.setVolumeOfOverWood(volumeOfOverWood);
        floorResults.setPriceOfOverWood(calculationService.round(volumeOfOverWood * getPriceByTypeId(overMaterials, 1L)));

        double squareOfOverOsb = calculationService.getOverOsbSquare(floor);
        floorResults.setNameOfOverOsb(getNameByTypeId(overMaterials, 2L));
        floorResults.setSquareOfOverOsb(squareOfOverOsb);
        floorResults.setPriceOfOverOsb(calculationService.round(squareOfOverOsb * getPriceByTypeId(overMaterials, 2L)));

        double volumeOfOverWarm = calculationService.getOverVolumeOfWarm(floor);
        floorResults.setNameOfOverWarm(getNameByTypeId(overMaterials, 3L));
        floorResults.setVolumeOfOverWarm(volumeOfOverWarm);
        floorResults.setPriceOfOverWarm(calculationService.round(volumeOfOverWarm * getPriceByTypeId(overMaterials, 3L)));

        double squareOfOverWaterAndWind = calculationService.getOverWindAndWaterSquare(floor);
        floorResults.setNameOfOverWater(getNameByTypeId(overMaterials, 4L));
        floorResults.setSquareOfOverWater(squareOfOverWaterAndWind);
        floorResults.setPriceOfOverWater(calculationService.round(squareOfOverWaterAndWind * getPriceByTypeId(overMaterials, 4L)));

        floorResults.setNameOfOverWind(getNameByTypeId(overMaterials, 5L));
        floorResults.setSquareOfOverWind(squareOfOverWaterAndWind);
        floorResults.setPriceOfOverWind(calculationService.round(squareOfOverWaterAndWind * getPriceByTypeId(overMaterials, 5L)));

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
