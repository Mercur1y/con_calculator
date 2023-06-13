package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_roof_results")
public class RoofResults extends AbstractElement {

    //Стропила
    @Column
    private String nameOfRaftersWood;
    @Column
    private Double volumeOfRaftersWood;
    @Column
    private Double priceOfRaftersWood;

    //Обрешетка
    @Column
    private String nameOfLathWood;
    @Column
    private Double volumeOfLathWood;
    @Column
    private Double priceOfLathWood;

    //Парогидроизоляция
    @Column
    private String nameOfWater;
    @Column
    private Double squareOfWater;
    @Column
    private Double priceOfWater;

    //Утеплитель
    @Column
    private String nameOfWarm;
    @Column
    private Double volumeOfWarm;
    @Column
    private Double priceOfWarm;

    //Кровля
    @Column
    private String nameOfTop;
    @Column
    private Double squareOfTop;
    @Column
    private Double priceOfTop;

    @Column
    private Double totalPriceOfFrame;
    @Column
    private Double totalPriceOfCover;
    @Column
    private Double totalPriceOfTop;
    @Column
    private Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roof_id", referencedColumnName = "id")
    private Roof roof;

}
