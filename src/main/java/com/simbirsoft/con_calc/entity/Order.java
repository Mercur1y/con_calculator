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
@Table(name = "t_order")
public class Order extends AbstractElement {

    @Column
    private Double totalPrice;

    @Column
    private String localDateTime;

    @Column
    private String adress;

    @Column
    public String status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Floor> floors;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Foundation foundation;

    @OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Roof roof;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
