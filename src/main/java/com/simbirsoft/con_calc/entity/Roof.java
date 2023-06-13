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
@Table(name = "t_roof")
public class Roof extends AbstractElement{

    @Column
    Double length;

    @Column
    Double width;

    @Column
    Double height;

    @Column
    Double overhang;

    @Column
    Integer type;

    @OneToMany(mappedBy = "roof", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToOne(mappedBy = "roof", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RoofResults roofResults;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
