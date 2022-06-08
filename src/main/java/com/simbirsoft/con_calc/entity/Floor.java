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
    private Integer number;

    @Column
    private Double outPerimeter;

    @Column
    private Double inPerimeter;

    @Column
    private Double height;

    @Column
    private Double square;

    @Column
    private Integer overWidth;

    @Column
    private Integer outWallWidth;

    @Column
    private Integer inWallWidth;

    @Column
    private Boolean isFirst;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hole> holes;

    @OneToOne(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FloorResults floorResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
