package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {
    Set<Material> findAllByTypeId(Long id);
    Material findByTypeId(Long id);
    Material findByName(String name);
    Material getByLengthAndWidth(Short length, Short width);
}
