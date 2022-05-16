package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

@Entity
@Table(name = "t_floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double height;
    private Double perimeter;
    private Double square;
    private Integer outWallWidth;
    private Integer inWallWidth;
    private Double inWallLength;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hole> holes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Integer getOutWallWidth() {
        return outWallWidth;
    }

    public void setOutWallWidth(Integer outWallWidth) {
        this.outWallWidth = outWallWidth;
    }

    public Integer getInWallWidth() {
        return inWallWidth;
    }

    public void setInWallWidth(Integer inWallWidth) {
        this.inWallWidth = inWallWidth;
    }

    public Double getInWallLength() {
        return inWallLength;
    }

    public void setInWallLength(Double inWallLength) {
        this.inWallLength = inWallLength;
    }

    public Set<WallCladding> getWallCladdings() {
        return wallCladdings;
    }

    public void setWallCladdings(Set<WallCladding> wallCladdings) {
        this.wallCladdings = wallCladdings;
    }

    public Set<Hole> getHoles() {
        return holes;
    }

    public void setHoles(Set<Hole> holes) {
        this.holes = holes;
    }
}
