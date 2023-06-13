package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Roof;
import com.simbirsoft.con_calc.entity.WallCladding;
import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallCladdingRepo extends JpaRepository<WallCladding, Long> {
    WallCladding findByFloorAndType (Floor floor, WallCladdingTypeEnum type);
    WallCladding getByFoundation (Foundation foundation);
    WallCladding getByRoof (Roof roof);
}
