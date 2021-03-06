package com.simbirsoft.con_calc.entity;

import com.simbirsoft.con_calc.entity.enums.HoleTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.stream.DoubleStream;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_hole")
public class Hole extends AbstractElement {

    @Column
    @Enumerated(EnumType.STRING)
    private HoleTypeEnum type;

    @Column
    private Double width;

    @Column
    private Double height;

    @Column
    private Short count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    public Double getCountPerimeter() {
        return (this.width + this.height) * 2 * this.count;
    }

    public Double getCountSquare() {return  this.width * this.height * this.count;}
}
