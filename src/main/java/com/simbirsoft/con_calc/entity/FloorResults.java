package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_floor_results")
public class FloorResults extends AbstractElement {

    @Column
    String nameOfOutWood;
    @Column
    Double volumeOfOutWood;
    @Column
    Double priceOfOutWood;

    @Column
    String nameOfInWood;
    @Column
    Double volumeOfInWood;
    @Column
    Double priceOfInWood;

    @Column
    String nameOfOverWood;
    @Column
    Double volumeOfOverWood;
    @Column
    Double priceOfOverWood;

    @Column
    String nameOfOutOsb;
    @Column
    Double squareOfOutOsb;
    @Column
    Double priceOfOutOsb;

    @Column
    String nameOfInOsb;
    @Column
    Double squareOfInOsb;
    @Column
    Double priceOfInOsb;

    @Column
    String nameOfOverOsb;
    @Column
    Double squareOfOverOsb;
    @Column
    Double priceOfOverOsb;

    @Column
    String nameOfOutWind;
    @Column
    Double squareOfOutWind;
    @Column
    Double priceOfOutWind;

    @Column
    String nameOfOutWater;
    @Column
    Double squareOfOutWater;
    @Column
    Double priceOfOutWater;

    @Column
    String nameOfOverWind;
    @Column
    Double squareOfOverWind;
    @Column
    Double priceOfOverWind;

    @Column
    String nameOfOverWater;
    @Column
    Double squareOfOverWater;
    @Column
    Double priceOfOverWater;

    @Column
    String nameOfOutWarm;
    @Column
    Double volumeOfOutWarm;
    @Column
    Double priceOfOutWarm;

    @Column
    String nameOfOverWarm;
    @Column
    Double volumeOfOverWarm;
    @Column
    Double priceOfOverWarm;

    @Column
    Double totalOutPrice;
    @Column
    Double totalInPrice;
    @Column
    Double totalOverPrice;
    @Column
    Double totalAllPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    Floor floor;
}
