package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.FloorResults;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.view.FoundationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoundationService {

    @Autowired
    FoundationRepo foundationRepo;

    public Foundation findFoundationById(Long id) {
        Optional<Foundation> foundationFromDb = foundationRepo.findById(id);
        return foundationFromDb.orElse(new Foundation());
    }

    public void updateFoundation (Foundation foundation, Long id) {
        Foundation foundationFromDB = foundationRepo.getById(id);
        foundationFromDB.setInPerimeter(foundation.getInPerimeter());
        foundationFromDB.setOutPerimeter(foundation.getOutPerimeter());
        foundationRepo.save(foundationFromDB);
    }
}
