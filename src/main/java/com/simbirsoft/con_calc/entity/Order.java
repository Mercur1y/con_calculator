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

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Floor> floors;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Foundation> foundations;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
