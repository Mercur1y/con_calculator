package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.view.FoundationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoundationService {

    private final FoundationRepo foundationRepo;

    public Foundation findFoundationById(Long id) {
        Optional<Foundation> foundationFromDb = foundationRepo.findById(id);
        return foundationFromDb.orElse(new Foundation());
    }

    public void addFoundation (Order order, Foundation foundation) {

        if(order.getFoundations() == null || order.getFoundations().isEmpty()) {
            foundation.setNumber(1);
        }
        else {
            foundation.setNumber(
                    (order
                            .getFoundations()
                            .stream()
                            .map(Foundation::getNumber)
                            .sorted()
                            .reduce((a, b) -> b)
                            .get()) + 1
            );
        }

        foundation.setOrder(order);
        foundationRepo.save(foundation);
    }

    public void updateFoundation (Foundation foundation, Long id) {
        Foundation foundationFromDB = foundationRepo.getById(id);
        foundationFromDB.setInPerimeter(foundation.getInPerimeter());
        foundationFromDB.setOutPerimeter(foundation.getOutPerimeter());
        foundationRepo.save(foundationFromDB);
    }
}
