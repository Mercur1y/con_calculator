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
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Double totalPrice;

    @Column
    String localDateTime;

    @Column
    String adress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    Set<Floor> floors;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    Set<Foundation> foundations;

    @ManyToOne(fetch = FetchType.LAZY)
    Customer customer;
}
