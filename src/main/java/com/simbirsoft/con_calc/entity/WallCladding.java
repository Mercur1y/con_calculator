package com.simbirsoft.con_calc.entity;

import com.simbirsoft.con_calc.entity.enums.WallCladdingTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_wallcladding")
public class WallCladding extends AbstractElement {

    @Column
    @Enumerated(EnumType.STRING)
    WallCladdingTypeEnum type;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Material> materials;

    @ManyToOne(fetch = FetchType.LAZY)
    Floor floor;

    @ManyToOne(fetch = FetchType.LAZY)
    Foundation foundation;
}
