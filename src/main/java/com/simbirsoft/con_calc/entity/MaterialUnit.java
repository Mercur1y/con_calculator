package com.simbirsoft.con_calc.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_materialUnit")
public class MaterialUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unit;

    public MaterialUnit() {
    }

    @OneToOne(mappedBy = "unit")
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
