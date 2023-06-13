package com.simbirsoft.con_calc.dto.roofResults;

import com.simbirsoft.con_calc.dto.roof.RoofChoiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoofResultsViewDto {
    //Стропила
    private String nameOfRaftersWood;
    
    private Double volumeOfRaftersWood;
    
    private Double priceOfRaftersWood;

    //Обрешетка
    private String nameOfLathWood;
    
    private Double volumeOfLathWood;
    
    private Double priceOfLathWood;

    //Парогидроизоляция
    private String nameOfWater;
    
    private Double squareOfWater;
    
    private Double priceOfWater;

    //Утеплитель
    private String nameOfWarm;
    
    private Double volumeOfWarm;
    
    private Double priceOfWarm;

    //Кровля
    private String nameOfTop;
    
    private Double squareOfTop;
    
    private Double priceOfTop;

    
    private Double totalPriceOfFrame;
    
    private Double totalPriceOfCover;
    
    private Double totalPriceOfTop;
    
    private Double totalPrice;

    private RoofChoiceDto roof;
}
