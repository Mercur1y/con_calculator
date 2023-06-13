package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.dto.roof.RoofEditDto;
import com.simbirsoft.con_calc.dto.roof.RoofCreationDto;
import com.simbirsoft.con_calc.entity.Roof;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.RoofMapper;
import com.simbirsoft.con_calc.view.RoofRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoofService {
    
    private final RoofRepo roofRepo;
    private final RoofMapper roofMapper;

    public RoofEditDto getForEdit(Long id) {
        return roofMapper.toEditDto(findRoofById(id));
    }

    public Roof findRoofById(Long id) {
        Optional<Roof> roofFromDb = roofRepo.findById(id);
        return roofFromDb.orElse(new Roof());
    }

    public Roof addRoof (Order order, RoofCreationDto Roof) {

        Roof roofEntity = roofMapper.toCreationEntity(Roof);

        roofEntity.setOrder(order);
        roofRepo.save(roofEntity);
        return roofEntity;
    }

    public void updateRoof (RoofEditDto roof, Long id) {
        Roof roofFromDB = roofRepo.getById(id);
        roofFromDB.setHeight(roof.getHeight());
        roofFromDB.setWidth(roof.getWidth());
        roofFromDB.setLength(roof.getLength());
        roofFromDB.setOverhang(roof.getOverhang());
        roofRepo.save(roofFromDB);
    }
}
