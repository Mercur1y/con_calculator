package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_material")
public class Material extends AbstractElement {

    @Column
    String name;

    @Column
    Double price;

    @Column
    Integer length;

    @Column
    Integer width;

    @Column
    Integer height;

    @Transient
    @ManyToMany(mappedBy = "materials")
    Set<WallCladding> wallCladdingSet;

    @ManyToOne(fetch = FetchType.LAZY)
    MaterialType type;
}
