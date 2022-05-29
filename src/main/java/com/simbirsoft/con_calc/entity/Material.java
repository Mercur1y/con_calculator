package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer length;
    private Integer width;
    private Integer height;

    public Material() {
    }

    @Transient
    @ManyToMany(mappedBy = "materials")
    private Set<WallCladding> wallCladdingSet;

    @ManyToOne(fetch = FetchType.LAZY)
    private MaterialType type;

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Set<WallCladding> getWallCladdingSet() {
        return wallCladdingSet;
    }

    public void setWallCladdingSet(Set<WallCladding> wallCladdingSet) {
        this.wallCladdingSet = wallCladdingSet;
    }
}
