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
@Table(name = "t_foundation")
public class Foundation extends AbstractElement {

    @Column
    Integer number;

    @Column
    Double outPerimeter;

    @Column
    Double inPerimeter;

    @OneToMany(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<WallCladding> wallCladdings;

    @OneToOne(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    FoundationResults foundationResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order;
}
