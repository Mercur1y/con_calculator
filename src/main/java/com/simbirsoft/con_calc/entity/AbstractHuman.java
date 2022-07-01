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
    protected String lastName;

    @Column
    protected String firstName;

    @Column
    protected String secondName;

    @Column
    protected String email;

    @Column
    protected String phone;
}

