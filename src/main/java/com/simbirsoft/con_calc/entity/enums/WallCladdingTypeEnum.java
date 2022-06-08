package com.simbirsoft.con_calc.entity.enums;

import lombok.Getter;

public enum WallCladdingTypeEnum {
    IN ("Внутренняя обшивка"),
    OUT ("Внешняя обшивка"),
    OVERLAP ("Обшивка перекрытий"),
    GROUND ("Обшивка фундамента");

    private WallCladdingTypeEnum (final String comment) {this.comment = comment;}

    @Getter
    private final String comment;
}
