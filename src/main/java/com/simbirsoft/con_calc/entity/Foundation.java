package com.simbirsoft.con_calc.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_foundation")
public class Foundation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double outPerimeter;
    private Double inPerimeter;
}
