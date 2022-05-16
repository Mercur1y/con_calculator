package com.simbirsoft.con_calc.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_materialType")
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public MaterialType() {
    }

    @OneToOne(mappedBy = "type")
    private Material material;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private MaterialUnit unit;

    public MaterialUnit getUnit() {
        return unit;
    }

    public void setUnit(MaterialUnit unit) {
        this.unit = unit;
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
}
