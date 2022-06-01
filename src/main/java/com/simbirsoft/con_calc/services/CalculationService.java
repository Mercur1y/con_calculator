package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Foundation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {

    public double round(double result) {
        return Math.ceil(result * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public double getWallVolumeOfWood(Floor floor, String type) {
        System.out.println(floor.getHoles());
        List<Double> list = new ArrayList<>();
        floor.getHoles().forEach(x -> list.add(x.getCountPerimeter()));

        double countOfWoodOnOutStand = (floor.getOutPerimeter() / 0.6) + 1;
        double countOfWoodOnInStand = floor.getInPerimeter() / 0.6;
        double countOfWoodOnGround = floor.getOutPerimeter() * 2 / 3;
        if(!floor.getIsFirst()) countOfWoodOnGround /= 2; //Если не первый /2
        double countOfWoodOnHoles = list.stream()
                .mapToDouble(Double::doubleValue).sum() / 3;

        double outVolume = (countOfWoodOnGround
                + countOfWoodOnOutStand
                + countOfWoodOnHoles
        ) * floor.getOutWallWidth() / 1000 * 0.05 * 3;

        double inVolume = countOfWoodOnInStand * floor.getInWallWidth() / 1000 * 0.05 * 3;

        if(type.equals("out")) return round(outVolume);
        else return round(inVolume);
    }

    public double getOverVolumeOfWood(Floor floor) {
        return round(floor.getSquare() * 0.7 * floor.getOverWidth() * 0.05 * 6 / 1000);
    }

    public double getWallOsbSquare(Floor floor, String type) {
        if(type.equals("out")) return round(floor.getOutPerimeter() * floor.getHeight() * 2 * 1.15);
        else return round(floor.getInPerimeter() * floor.getHeight() * 2 * 1.15);
    }

    public double getOverOsbSquare(Floor floor) {
        if(!floor.getIsFirst()) return round(floor.getSquare() * 1.15 * 4 / 2); //Если не первый /2
        else return round(floor.getSquare() * 1.15 * 4);
    }

    public double getOutWindAndWaterSquare(Floor floor) {
        return round(floor.getOutPerimeter() * floor.getHeight() * 1.15);
    }

    public double getOverWindAndWaterSquare(Floor floor) {
        return round(floor.getSquare() * 1.15);
    }

    public double getOutVolumeOfWarm(Floor floor) {
        List<Double> list = new ArrayList<>();
        floor.getHoles().forEach(x -> list.add(x.getCountSquare()));
        double square = floor.getOutPerimeter() * floor.getHeight() * 1.1
                - list
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
        return round(square * floor.getOutWallWidth() / 1000);
    }

    public double getOverVolumeOfWarm(Floor floor) {
        return round(floor.getSquare() * 2 * 1.1 * floor.getOverWidth() / 1000);
    }

    public int getCountOfPiles(Foundation foundation) {
        return (int) ((foundation.getOutPerimeter() + foundation.getInPerimeter()) / 2);
    }

    public double getVolumeOfConcrete(Foundation foundation) {
        return round((foundation.getOutPerimeter() + foundation.getInPerimeter()) * 0.3 * 0.4 * 1.15);
    }

    public int getCountOfBigArm (Foundation foundation) {
        return (int) ((foundation.getOutPerimeter() + foundation.getInPerimeter()) * 4 / 6);
    }

    public int getCountOfSmallArm (Foundation foundation) {
        return (int) ((foundation.getOutPerimeter() + foundation.getInPerimeter()) / 0.3 * 0.5 / 3);
    }

    public double getVolumeOfGroundWood (Foundation foundation) {
        return round((foundation.getOutPerimeter() + foundation.getInPerimeter()) * 2 * 0.5 * 0.03);
    }

    public double getVolumeOfGroundBalk (Foundation foundation) {
        return round((foundation.getOutPerimeter() + foundation.getInPerimeter()) * 2 / 0.7 * 0.5 * 0.05 * 0.05);
    }
}
