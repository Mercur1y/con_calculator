package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_foundation_results")
public class FoundationResults {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nameOfPiles;
    @Column
    Integer countOfPiles;
    @Column
    Double priceOfPiles;

    @Column
    String nameOfConcrete;
    @Column
    Double volumeOfConcrete;
    @Column
    Double priceOfConcrete;

    @Column
    String nameOfBigArm;
    @Column
    Integer countOfBigArm;
    @Column
    Double priceOfBigArm;

    @Column
    String nameOfSmallArm;
    @Column
    Integer countOfSmallArm;
    @Column
    Double priceOfSmallArm;

    @Column
    String nameOfWood;
    @Column
    Double volumeOfWood;
    @Column
    Double priceOfWood;

    @Column
    String nameOfBalk;
    @Column
    Double volumeOfBalk;
    @Column
    Double priceOfBalk;

    @Column
    Double totalPriceOfGrillage;
    @Column
    Double totalPriceOfFormwork;
    @Column
    Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foundation_id", referencedColumnName = "id")
    Foundation foundation;
}