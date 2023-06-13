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
    private Double outPerimeter;

    @Column
    private Double inPerimeter;

    @OneToMany(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToOne(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FoundationResults foundationResults;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
