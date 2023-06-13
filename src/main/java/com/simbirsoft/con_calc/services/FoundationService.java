package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.foundation.FoundationCreationDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.FoundationMapper;
import com.simbirsoft.con_calc.view.FoundationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoundationService {

    private final FoundationRepo foundationRepo;
    private final FoundationMapper foundationMapper;

    public Foundation findFoundationById(Long id) {
        Optional<Foundation> foundationFromDb = foundationRepo.findById(id);
        return foundationFromDb.orElse(new Foundation());
    }

    public FoundationEditDto getForEdit(Long id) {
        return foundationMapper.toEditDto(findFoundationById(id));
    }

    public Foundation addFoundation (Order order, FoundationCreationDto foundation) {

        Foundation foundationEntity = foundationMapper.toCreationEntity(foundation);

        foundationEntity.setOrder(order);
        foundationRepo.save(foundationEntity);
        return foundationEntity;
    }

    public void updateFoundation (FoundationEditDto foundation, Long id) {
        Foundation foundationFromDB = foundationRepo.getById(id);
        foundationFromDB.setInPerimeter(foundation.getInPerimeter());
        foundationFromDB.setOutPerimeter(foundation.getOutPerimeter());
        foundationRepo.save(foundationFromDB);
    }
}
