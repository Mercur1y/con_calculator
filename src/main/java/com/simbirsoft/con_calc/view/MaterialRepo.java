package com.simbirsoft.con_calc.view;

import com.simbirsoft.con_calc.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {
    Set<Material> findAllByTypeId(Long id);
    Material getByTypeIdAndWidth(Long id, Integer width);
    Material getByTypeId(Long id);
    Material getByLengthAndWidthAndHeight(Integer length, Integer width, Integer height);
    Material getByName(String name);
    Material getByWidth (Integer width);
}
