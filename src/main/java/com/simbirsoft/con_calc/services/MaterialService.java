package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Material;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.view.MaterialRepo;
import com.simbirsoft.con_calc.view.MaterialTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MaterialService {

    @Autowired
    MaterialRepo materialRepo;

    @Autowired
    MaterialTypeRepo materialTypeRepo;

    public Material findMaterialById(Long id) {
        Optional<Material> material = materialRepo.findById(id);
        return material.orElse(new Material());
    }

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
}
