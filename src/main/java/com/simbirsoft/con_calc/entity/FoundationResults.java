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
public class FoundationResults extends AbstractElement {

    @Column
    private String nameOfPiles;
    @Column
    private Integer countOfPiles;
    @Column
    private Double priceOfPiles;

    @Column
    private String nameOfConcrete;
    @Column
    private Double volumeOfConcrete;
    @Column
    private Double priceOfConcrete;

    @Column
    private String nameOfBigArm;
    @Column
    private Integer countOfBigArm;
    @Column
    private Double priceOfBigArm;

    @Column
    private String nameOfSmallArm;
    @Column
    private Integer countOfSmallArm;
    @Column
    private Double priceOfSmallArm;

    @Column
    private String nameOfWood;
    @Column
    private Double volumeOfWood;
    @Column
    private Double priceOfWood;

    @Column
    private String nameOfBalk;
    @Column
    private Double volumeOfBalk;
    @Column
    private Double priceOfBalk;

    @Column
    private Double totalPriceOfGrillage;
    @Column
    private Double totalPriceOfFormwork;
    @Column
    private Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foundation_id", referencedColumnName = "id")
    private Foundation foundation;
}