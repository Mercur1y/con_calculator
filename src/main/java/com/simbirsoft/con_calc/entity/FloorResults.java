package com.simbirsoft.con_calc.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "t_floor_results")
public class FloorResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfOutWood;
    private Double volumeOfOutWood;
    private Double priceOfOutWood;

    private String nameOfInWood;
    private Double volumeOfInWood;
    private Double priceOfInWood;

    private String nameOfOverWood;
    private Double volumeOfOverWood;
    private Double priceOfOverWood;

    private String nameOfOutOsb;
    private Double squareOfOutOsb;
    private Double priceOfOutOsb;

    private String nameOfInOsb;
    private Double squareOfInOsb;
    private Double priceOfInOsb;

    private String nameOfOverOsb;
    private Double squareOfOverOsb;
    private Double priceOfOverOsb;

    private String nameOfOutWind;
    private Double squareOfOutWind;
    private Double priceOfOutWind;

    private String nameOfOutWater;
    private Double squareOfOutWater;
    private Double priceOfOutWater;

    private String nameOfOverWind;
    private Double squareOfOverWind;
    private Double priceOfOverWind;

    private String nameOfOverWater;
    private Double squareOfOverWater;
    private Double priceOfOverWater;

    private String nameOfOutWarm;
    private Double volumeOfOutWarm;
    private Double priceOfOutWarm;

    private String nameOfOverWarm;
    private Double volumeOfOverWarm;
    private Double priceOfOverWarm;

    private Double totalOutPrice;
    private Double totalInPrice;
    private Double totalOverPrice;
    private Double totalAllPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    private Floor floor;

    public FloorResults() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfOutWood() {
        return nameOfOutWood;
    }

    public void setNameOfOutWood(String nameOfOutWood) {
        this.nameOfOutWood = nameOfOutWood;
    }

    public Double getVolumeOfOutWood() {
        return volumeOfOutWood;
    }

    public void setVolumeOfOutWood(Double volumeOfOutWood) {
        this.volumeOfOutWood = volumeOfOutWood;
    }

    public Double getPriceOfOutWood() {
        return priceOfOutWood;
    }

    public void setPriceOfOutWood(Double priceOfOutWood) {
        this.priceOfOutWood = priceOfOutWood;
    }

    public String getNameOfInWood() {
        return nameOfInWood;
    }

    public void setNameOfInWood(String nameOfInWood) {
        this.nameOfInWood = nameOfInWood;
    }

    public Double getVolumeOfInWood() {
        return volumeOfInWood;
    }

    public void setVolumeOfInWood(Double volumeOfInWood) {
        this.volumeOfInWood = volumeOfInWood;
    }

    public Double getPriceOfInWood() {
        return priceOfInWood;
    }

    public void setPriceOfInWood(Double priceOfInWood) {
        this.priceOfInWood = priceOfInWood;
    }

    public String getNameOfOverWood() {
        return nameOfOverWood;
    }

    public void setNameOfOverWood(String nameOfOverWood) {
        this.nameOfOverWood = nameOfOverWood;
    }

    public Double getVolumeOfOverWood() {
        return volumeOfOverWood;
    }

    public void setVolumeOfOverWood(Double volumeOfOverWood) {
        this.volumeOfOverWood = volumeOfOverWood;
    }

    public Double getPriceOfOverWood() {
        return priceOfOverWood;
    }

    public void setPriceOfOverWood(Double priceOfOverWood) {
        this.priceOfOverWood = priceOfOverWood;
    }

    public String getNameOfOutOsb() {
        return nameOfOutOsb;
    }

    public void setNameOfOutOsb(String nameOfOutOsb) {
        this.nameOfOutOsb = nameOfOutOsb;
    }

    public Double getSquareOfOutOsb() {
        return squareOfOutOsb;
    }

    public void setSquareOfOutOsb(Double squareOfOutOsb) {
        this.squareOfOutOsb = squareOfOutOsb;
    }

    public Double getPriceOfOutOsb() {
        return priceOfOutOsb;
    }

    public void setPriceOfOutOsb(Double priceOfOutOsb) {
        this.priceOfOutOsb = priceOfOutOsb;
    }

    public String getNameOfInOsb() {
        return nameOfInOsb;
    }

    public void setNameOfInOsb(String nameOfInOsb) {
        this.nameOfInOsb = nameOfInOsb;
    }

    public Double getSquareOfInOsb() {
        return squareOfInOsb;
    }

    public void setSquareOfInOsb(Double squareOfInOsb) {
        this.squareOfInOsb = squareOfInOsb;
    }

    public Double getPriceOfInOsb() {
        return priceOfInOsb;
    }

    public void setPriceOfInOsb(Double priceOfInOsb) {
        this.priceOfInOsb = priceOfInOsb;
    }

    public String getNameOfOverOsb() {
        return nameOfOverOsb;
    }

    public void setNameOfOverOsb(String nameOfOverOsb) {
        this.nameOfOverOsb = nameOfOverOsb;
    }

    public Double getSquareOfOverOsb() {
        return squareOfOverOsb;
    }

    public void setSquareOfOverOsb(Double squareOfOverOsb) {
        this.squareOfOverOsb = squareOfOverOsb;
    }

    public Double getPriceOfOverOsb() {
        return priceOfOverOsb;
    }

    public void setPriceOfOverOsb(Double priceOfOverOsb) {
        this.priceOfOverOsb = priceOfOverOsb;
    }

    public String getNameOfOutWind() {
        return nameOfOutWind;
    }

    public void setNameOfOutWind(String nameOfOutWind) {
        this.nameOfOutWind = nameOfOutWind;
    }

    public Double getSquareOfOutWind() {
        return squareOfOutWind;
    }

    public void setSquareOfOutWind(Double squareOfOutWind) {
        this.squareOfOutWind = squareOfOutWind;
    }

    public Double getPriceOfOutWind() {
        return priceOfOutWind;
    }

    public void setPriceOfOutWind(Double priceOfOutWind) {
        this.priceOfOutWind = priceOfOutWind;
    }

    public String getNameOfOutWater() {
        return nameOfOutWater;
    }

    public void setNameOfOutWater(String nameOfOutWater) {
        this.nameOfOutWater = nameOfOutWater;
    }

    public Double getSquareOfOutWater() {
        return squareOfOutWater;
    }

    public void setSquareOfOutWater(Double squareOfOutWater) {
        this.squareOfOutWater = squareOfOutWater;
    }

    public Double getPriceOfOutWater() {
        return priceOfOutWater;
    }

    public void setPriceOfOutWater(Double priceOfOutWater) {
        this.priceOfOutWater = priceOfOutWater;
    }

    public String getNameOfOverWind() {
        return nameOfOverWind;
    }

    public void setNameOfOverWind(String nameOfOverWind) {
        this.nameOfOverWind = nameOfOverWind;
    }

    public Double getSquareOfOverWind() {
        return squareOfOverWind;
    }

    public void setSquareOfOverWind(Double squareOfOverWind) {
        this.squareOfOverWind = squareOfOverWind;
    }

    public Double getPriceOfOverWind() {
        return priceOfOverWind;
    }

    public void setPriceOfOverWind(Double priceOfOverWind) {
        this.priceOfOverWind = priceOfOverWind;
    }

    public String getNameOfOverWater() {
        return nameOfOverWater;
    }

    public void setNameOfOverWater(String nameOfOverWater) {
        this.nameOfOverWater = nameOfOverWater;
    }

    public Double getSquareOfOverWater() {
        return squareOfOverWater;
    }

    public void setSquareOfOverWater(Double squareOfOverWater) {
        this.squareOfOverWater = squareOfOverWater;
    }

    public Double getPriceOfOverWater() {
        return priceOfOverWater;
    }

    public void setPriceOfOverWater(Double priceOfOverWater) {
        this.priceOfOverWater = priceOfOverWater;
    }

    public String getNameOfOutWarm() {
        return nameOfOutWarm;
    }

    public void setNameOfOutWarm(String nameOfOutWarm) {
        this.nameOfOutWarm = nameOfOutWarm;
    }

    public Double getVolumeOfOutWarm() {
        return volumeOfOutWarm;
    }

    public void setVolumeOfOutWarm(Double volumeOfOutWarm) {
        this.volumeOfOutWarm = volumeOfOutWarm;
    }

    public Double getPriceOfOutWarm() {
        return priceOfOutWarm;
    }

    public void setPriceOfOutWarm(Double priceOfOutWarm) {
        this.priceOfOutWarm = priceOfOutWarm;
    }

    public String getNameOfOverWarm() {
        return nameOfOverWarm;
    }

    public void setNameOfOverWarm(String nameOfOverWarm) {
        this.nameOfOverWarm = nameOfOverWarm;
    }

    public Double getVolumeOfOverWarm() {
        return volumeOfOverWarm;
    }

    public void setVolumeOfOverWarm(Double volumeOfOverWarm) {
        this.volumeOfOverWarm = volumeOfOverWarm;
    }

    public Double getPriceOfOverWarm() {
        return priceOfOverWarm;
    }

    public void setPriceOfOverWarm(Double priceOfOverWarm) {
        this.priceOfOverWarm = priceOfOverWarm;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Double getTotalOutPrice() {
        return totalOutPrice;
    }

    public void setTotalOutPrice(Double totalOutPrice) {
        this.totalOutPrice = totalOutPrice;
    }

    public Double getTotalInPrice() {
        return totalInPrice;
    }

    public void setTotalInPrice(Double totalInPrice) {
        this.totalInPrice = totalInPrice;
    }

    public Double getTotalOverPrice() {
        return totalOverPrice;
    }

    public void setTotalOverPrice(Double totalOverPrice) {
        this.totalOverPrice = totalOverPrice;
    }

    public Double getTotalAllPrice() {
        return totalAllPrice;
    }

    public void setTotalAllPrice(Double totalAllPrice) {
        this.totalAllPrice = totalAllPrice;
    }
}
