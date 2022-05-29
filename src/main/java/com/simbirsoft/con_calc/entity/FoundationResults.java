package com.simbirsoft.con_calc.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_foundation_results")
public class FoundationResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfPiles;
    private Integer countOfPiles;
    private Double priceOfPiles;

    private String nameOfConcrete;
    private Double volumeOfConcrete;
    private Double priceOfConcrete;

    private String nameOfBigArm;
    private Integer countOfBigArm;
    private Double priceOfBigArm;

    private String nameOfSmallArm;
    private Integer countOfSmallArm;
    private Double priceOfSmallArm;

    private String nameOfWood;
    private Double volumeOfWood;
    private Double priceOfWood;

    private String nameOfBalk;
    private Double volumeOfBalk;
    private Double priceOfBalk;

    private Double totalPriceOfGrillage;
    private Double totalPriceOfFormwork;
    private Double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foundation_id", referencedColumnName = "id")
    private Foundation foundation;

    public FoundationResults() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfPiles() {
        return nameOfPiles;
    }

    public void setNameOfPiles(String nameOfPiles) {
        this.nameOfPiles = nameOfPiles;
    }

    public Integer getCountOfPiles() {
        return countOfPiles;
    }

    public void setCountOfPiles(Integer countOfPiles) {
        this.countOfPiles = countOfPiles;
    }

    public Double getPriceOfPiles() {
        return priceOfPiles;
    }

    public void setPriceOfPiles(Double priceOfPiles) {
        this.priceOfPiles = priceOfPiles;
    }

    public String getNameOfConcrete() {
        return nameOfConcrete;
    }

    public void setNameOfConcrete(String nameOfConcrete) {
        this.nameOfConcrete = nameOfConcrete;
    }

    public Double getVolumeOfConcrete() {
        return volumeOfConcrete;
    }

    public void setVolumeOfConcrete(Double volumeOfConcrete) {
        this.volumeOfConcrete = volumeOfConcrete;
    }

    public Double getPriceOfConcrete() {
        return priceOfConcrete;
    }

    public void setPriceOfConcrete(Double priceOfConcrete) {
        this.priceOfConcrete = priceOfConcrete;
    }

    public String getNameOfBigArm() {
        return nameOfBigArm;
    }

    public void setNameOfBigArm(String nameOfBigArm) {
        this.nameOfBigArm = nameOfBigArm;
    }

    public Integer getCountOfBigArm() {
        return countOfBigArm;
    }

    public void setCountOfBigArm(Integer countOfBigArm) {
        this.countOfBigArm = countOfBigArm;
    }

    public Double getPriceOfBigArm() {
        return priceOfBigArm;
    }

    public void setPriceOfBigArm(Double priceOfBigArm) {
        this.priceOfBigArm = priceOfBigArm;
    }

    public String getNameOfSmallArm() {
        return nameOfSmallArm;
    }

    public void setNameOfSmallArm(String nameOfSmallArm) {
        this.nameOfSmallArm = nameOfSmallArm;
    }

    public Integer getCountOfSmallArm() {
        return countOfSmallArm;
    }

    public void setCountOfSmallArm(Integer countOfSmallArm) {
        this.countOfSmallArm = countOfSmallArm;
    }

    public Double getPriceOfSmallArm() {
        return priceOfSmallArm;
    }

    public void setPriceOfSmallArm(Double priceOfSmallArm) {
        this.priceOfSmallArm = priceOfSmallArm;
    }

    public String getNameOfWood() {
        return nameOfWood;
    }

    public void setNameOfWood(String nameOfWood) {
        this.nameOfWood = nameOfWood;
    }

    public Double getVolumeOfWood() {
        return volumeOfWood;
    }

    public void setVolumeOfWood(Double volumeOfWood) {
        this.volumeOfWood = volumeOfWood;
    }

    public Double getPriceOfWood() {
        return priceOfWood;
    }

    public void setPriceOfWood(Double priceOfWood) {
        this.priceOfWood = priceOfWood;
    }

    public String getNameOfBalk() {
        return nameOfBalk;
    }

    public void setNameOfBalk(String nameOfBalk) {
        this.nameOfBalk = nameOfBalk;
    }

    public Double getVolumeOfBalk() {
        return volumeOfBalk;
    }

    public void setVolumeOfBalk(Double volumeOfBalk) {
        this.volumeOfBalk = volumeOfBalk;
    }

    public Double getPriceOfBalk() {
        return priceOfBalk;
    }

    public void setPriceOfBalk(Double priceOfBalk) {
        this.priceOfBalk = priceOfBalk;
    }

    public Double getTotalPriceOfGrillage() {
        return totalPriceOfGrillage;
    }

    public void setTotalPriceOfGrillage(Double totalPriceOfGrillage) {
        this.totalPriceOfGrillage = totalPriceOfGrillage;
    }

    public Double getTotalPriceOfFormwork() {
        return totalPriceOfFormwork;
    }

    public void setTotalPriceOfFormwork(Double totalPriceOfFormwork) {
        this.totalPriceOfFormwork = totalPriceOfFormwork;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Foundation getFoundation() {
        return foundation;
    }

    public void setFoundation(Foundation foundation) {
        this.foundation = foundation;
    }
}