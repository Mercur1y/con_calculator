package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_material_type")
public class MaterialType {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Material> materials;
}
