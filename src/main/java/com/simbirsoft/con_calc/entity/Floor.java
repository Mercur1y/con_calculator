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
@Table(name = "t_floor")
public class Floor extends AbstractElement {

    @Column
    Integer number;

    @Column
    Double outPerimeter;

    @Column
    Double inPerimeter;

    @Column
    Double height;

    @Column
    Double square;

    @Column
    Integer overWidth;

    @Column
    Integer outWallWidth;

    @Column
    Integer inWallWidth;

    @Column
    Boolean isFirst;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<WallCladding> wallCladdings;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Hole> holes;

    @OneToOne(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    FloorResults floorResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order;
}
