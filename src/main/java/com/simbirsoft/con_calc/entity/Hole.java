package com.simbirsoft.con_calc.entity;

import com.simbirsoft.con_calc.entity.enums.HoleTypeEnum;

import javax.persistence.*;
import java.util.stream.DoubleStream;

@Entity
@Table(name = "t_hole")
public class Hole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private HoleTypeEnum type;
    private Double width;
    private Double height;
    private Short count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    public Hole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HoleTypeEnum getType() {
        return type;
    }

    public void setType(HoleTypeEnum type) {
        this.type = type;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Double getCountPerimeter() {
        return (this.width + this.height) * 2 * this.count;
    }

    public Double getCountSquare() {return  this.width * this.height * this.count;}
}
