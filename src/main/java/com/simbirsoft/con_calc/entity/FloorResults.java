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
    private String nameOfOutWood;
    @Column
    private Double volumeOfOutWood;
    @Column
    private Double priceOfOutWood;

    @Column
    private String nameOfInWood;
    @Column
    private Double volumeOfInWood;
    @Column
    private Double priceOfInWood;

    @Column
    private String nameOfOverWood;
    @Column
    private Double volumeOfOverWood;
    @Column
    private Double priceOfOverWood;

    @Column
    private String nameOfOutOsb;
    @Column
    private Double squareOfOutOsb;
    @Column
    private Double priceOfOutOsb;

    @Column
    private String nameOfInOsb;
    @Column
    private Double squareOfInOsb;
    @Column
    private Double priceOfInOsb;

    @Column
    private String nameOfOverOsb;
    @Column
    private Double squareOfOverOsb;
    @Column
    private Double priceOfOverOsb;

    @Column
    private String nameOfOutWind;
    @Column
    private Double squareOfOutWind;
    @Column
    private Double priceOfOutWind;

    @Column
    private String nameOfOutWater;
    @Column
    private Double squareOfOutWater;
    @Column
    private Double priceOfOutWater;

    @Column
    private String nameOfOverWind;
    @Column
    private Double squareOfOverWind;
    @Column
    private Double priceOfOverWind;

    @Column
    private String nameOfOverWater;
    @Column
    private Double squareOfOverWater;
    @Column
    private Double priceOfOverWater;

    @Column
    private String nameOfOutWarm;
    @Column
    private Double volumeOfOutWarm;
    @Column
    private Double priceOfOutWarm;

    @Column
    private String nameOfOverWarm;
    @Column
    private Double volumeOfOverWarm;
    @Column
    private Double priceOfOverWarm;

    @Column
    private Double totalOutPrice;
    @Column
    private Double totalInPrice;
    @Column
    private Double totalOverPrice;
    @Column
    private Double totalAllPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;
}
