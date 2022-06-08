package com.simbirsoft.con_calc.entity.enums;

import lombok.Getter;

public enum HoleTypeEnum {
    OUT ("Внешние проемы"),
    IN ("Внутренние проемы");

    private HoleTypeEnum (final String comment) {this.comment = comment;}

    @Getter
    private final String comment;
}
