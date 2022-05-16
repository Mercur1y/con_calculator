package com.simbirsoft.con_calc.entity;

import com.simbirsoft.con_calc.entity.enums.HoleTypeEnum;
import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_wallcladding")
public class WallCladding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double width;

    @Enumerated(EnumType.STRING)
    private WallCladdingTypeEnum type;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Material> materials;

    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    public WallCladding() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public WallCladdingTypeEnum getType() {
        return type;
    }

    public void setType(WallCladdingTypeEnum type) {
        this.type = type;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
