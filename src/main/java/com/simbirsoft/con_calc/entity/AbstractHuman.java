package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractHuman implements Serializable {

    @Column
    protected String last_name;

    @Column
    protected String first_name;

    @Column
    protected String second_name;

    @Column
    protected String email;

    @Column
    protected String phone;
}

