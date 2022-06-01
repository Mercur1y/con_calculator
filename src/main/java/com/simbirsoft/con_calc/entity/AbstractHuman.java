package com.simbirsoft.con_calc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractHuman {

    @Column
    String last_name;

    @Column
    String first_name;

    @Column
    String second_name;

    @Column
    String email;

    @Column
    String phone;
}

