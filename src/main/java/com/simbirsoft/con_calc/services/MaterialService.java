package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Material;
import com.simbirsoft.con_calc.view.MaterialRepo;
import com.simbirsoft.con_calc.view.MaterialTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepo materialRepo;

    public Set<Material> getWoodMaterials() {
        return materialRepo.findAllByTypeId(1L);
    }

    public Set<Material> getOsbMaterials() {
        return materialRepo.findAllByTypeId(2L);
    }

    public Set<Material> getWarmProofMaterials() {
        return materialRepo.findAllByTypeId(3L);
    }

    public Set<Material> getWaterProofMaterials() {
        return materialRepo.findAllByTypeId(4L);
    }

    public Set<Material> getWindProofMaterials() {
        return materialRepo.findAllByTypeId(5L);
    }

    public Set<Material> getPilesMaterials() {
        return materialRepo.findAllByTypeId(6L);
    }

    public Set<Material> getConcreteMaterials() {
        return materialRepo.findAllByTypeId(7L);
    }

    public Set<Material> getArmMaterials() {
        return materialRepo.findAllByTypeId(8L);
    }

    public Set<Material> getTopMaterials() {return materialRepo.findAllByTypeId(9L); }

    public Material getByTypeId (Set <Material> materials, Long id) {
        return  materials.stream()
                .filter(material -> material.getType().getId().equals(id))
                .findFirst()
                .get();
    }

    public Material getByTypeIdAndWidth (Set <Material> materials, Long id, Integer width) {
        return  materials.stream()
                .filter(material -> material.getType().getId().equals(id) && material.getWidth().equals(width))
                .findFirst()
                .get();
    }

    public String getNameByTypeId (Set <Material> materials, Long id) {
        return  materials.stream()
                .filter(material -> material.getType().getId().equals(id))
                .map(Material::getName)
                .findFirst()
                .get();
    }

    public double getPriceByTypeId (Set <Material> materials, Long id) {
        return  materials.stream()
                .filter(material -> material.getType().getId().equals(id))
                .map(Material::getPrice)
                .findFirst()
                .get();
    }

    public String getNameByWidth (Set <Material> materials, Integer width) {
        return  materials.stream()
                .filter(material -> (material.getWidth() != null && material.getWidth().equals(width)))
                .map(Material::getName)
                .findFirst()
                .get();
    }

    public double getPriceByWidth (Set <Material> materials, Integer width) {
        return  materials.stream()
                .filter(material -> (material.getWidth() != null && material.getWidth().equals(width)))
                .map(Material::getPrice)
                .findFirst()
                .get();
    }
}
