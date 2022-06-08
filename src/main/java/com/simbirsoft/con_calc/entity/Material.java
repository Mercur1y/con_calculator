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
    private String name;

    @Column
    private Double price;

    @Column
    private Integer length;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @Transient
    @ManyToMany(mappedBy = "materials")
    private Set<WallCladding> wallCladdingSet;

    @ManyToOne(fetch = FetchType.LAZY)
    private MaterialType type;
}
