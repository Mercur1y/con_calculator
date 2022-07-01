package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.FoundationResults;
import com.simbirsoft.con_calc.entity.Material;
import com.simbirsoft.con_calc.view.FoundationResultsRepo;
import com.simbirsoft.con_calc.view.WallCladdingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoundationResultsService {

    private final FoundationResultsRepo foundationResultsRepo;
    private final WallCladdingRepo wallCladdingRepo;
    private final CalculationService calculationService;
    private final MaterialService materialService;

    public void addUpdateResults (Foundation foundation) {
        FoundationResults foundationResults;

        if(foundation.getFoundationResults() == null) foundationResults = new FoundationResults();
        else {
            foundationResults = foundationResultsRepo.getById(foundation.getFoundationResults().getId());
        }

        Set<Material> materials = wallCladdingRepo.getByFoundation(foundation).getMaterials();

        int countOfPiles = calculationService.getCountOfPiles(foundation);
        foundationResults.setNameOfPiles(materialService.getNameByTypeId(materials, 6L));
        foundationResults.setCountOfPiles(countOfPiles);
        foundationResults.setPriceOfPiles(countOfPiles * materialService.getPriceByTypeId(materials, 6L));

        double volumeOfConcrete = calculationService.getVolumeOfConcrete(foundation);
        foundationResults.setNameOfConcrete(materialService.getNameByTypeId(materials, 7L));
        foundationResults.setVolumeOfConcrete(volumeOfConcrete);
        foundationResults.setPriceOfConcrete(volumeOfConcrete * materialService.getPriceByTypeId(materials, 7L));

        int countOfBigArm = calculationService.getCountOfBigArm(foundation);
        foundationResults.setNameOfBigArm(materialService.getNameByWidth(materials, 14));
        foundationResults.setCountOfBigArm(countOfBigArm);
        foundationResults.setPriceOfBigArm(countOfBigArm * materialService.getPriceByWidth(materials, 14));

        int countOfSmallArm = calculationService.getCountOfSmallArm(foundation);
        foundationResults.setNameOfSmallArm(materialService.getNameByWidth(materials, 8));
        foundationResults.setCountOfSmallArm(countOfSmallArm);
        foundationResults.setPriceOfSmallArm(countOfSmallArm * materialService.getPriceByWidth(materials, 8));

        double volumeOfWood = calculationService.getVolumeOfGroundWood(foundation);
        foundationResults.setNameOfWood(materialService.getNameByWidth(materials, 100));
        foundationResults.setVolumeOfWood(volumeOfWood);
        foundationResults.setPriceOfWood(volumeOfWood * materialService.getPriceByWidth(materials, 100));

        double volumeOfBalk = calculationService.getVolumeOfGroundBalk(foundation);
        foundationResults.setNameOfBalk(materialService.getNameByWidth(materials, 50));
        foundationResults.setVolumeOfBalk(volumeOfBalk);
        foundationResults.setPriceOfBalk(volumeOfBalk * materialService.getPriceByWidth(materials, 50));

        foundationResults.setTotalPriceOfGrillage(
                foundationResults.getPriceOfConcrete()
                + foundationResults.getPriceOfBigArm()
                + foundationResults.getPriceOfSmallArm()
        );

        foundationResults.setTotalPriceOfFormwork(
                foundationResults.getPriceOfWood()
                + foundationResults.getPriceOfBalk()
        );

        foundationResults.setTotalPrice(
                foundationResults.getTotalPriceOfGrillage()
                + foundationResults.getTotalPriceOfFormwork()
                + foundationResults.getPriceOfPiles()
        );

        foundationResults.setFoundation(foundation);
        foundationResultsRepo.save(foundationResults);
    }
}
