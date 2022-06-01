package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractElement {

    @Column
    Double outPerimeter;

    @Column
    Double inPerimeter;
}
