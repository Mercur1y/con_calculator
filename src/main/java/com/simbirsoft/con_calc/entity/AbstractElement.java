package com.simbirsoft.con_calc.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractElement {

    private Double outPerimeter;
    private Double inPerimeter;

    public Double getOutPerimeter() {
        return outPerimeter;
    }

    public void setOutPerimeter(Double outPerimeter) {
        this.outPerimeter = outPerimeter;
    }

    public Double getInPerimeter() {
        return inPerimeter;
    }

    public void setInPerimeter(Double inPerimeter) {
        this.inPerimeter = inPerimeter;
    }
}
