package com.simbirsoft.con_calc.dto.floorResults;

import com.simbirsoft.con_calc.dto.floor.FloorChoiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorResultsViewDto {

    private String nameOfOutWood;

    private Double volumeOfOutWood;

    private Double priceOfOutWood;

    private String nameOfInWood;

    private Double volumeOfInWood;

    private Double priceOfInWood;

    private String nameOfOverWood;

    private Double volumeOfOverWood;

    private Double priceOfOverWood;

    private String nameOfOutOsb;

    private Double squareOfOutOsb;

    private Double priceOfOutOsb;

    private String nameOfInOsb;

    private Double squareOfInOsb;

    private Double priceOfInOsb;

    private String nameOfOverOsb;

    private Double squareOfOverOsb;

    private Double priceOfOverOsb;

    private String nameOfOutWind;

    private Double squareOfOutWind;

    private Double priceOfOutWind;

    private String nameOfOutWater;

    private Double squareOfOutWater;

    private Double priceOfOutWater;

    private String nameOfOverWind;

    private Double squareOfOverWind;

    private Double priceOfOverWind;

    private String nameOfOverWater;

    private Double squareOfOverWater;

    private Double priceOfOverWater;

    private String nameOfOutWarm;

    private Double volumeOfOutWarm;

    private Double priceOfOutWarm;

    private String nameOfOverWarm;

    private Double volumeOfOverWarm;

    private Double priceOfOverWarm;

    private Double totalOutPrice;

    private Double totalInPrice;

    private Double totalOverPrice;

    private Double totalAllPrice;

    private FloorChoiceDto floor;
}
