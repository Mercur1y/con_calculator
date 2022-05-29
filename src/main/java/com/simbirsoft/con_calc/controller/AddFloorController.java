package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.*;
import com.simbirsoft.con_calc.services.*;
import com.simbirsoft.con_calc.view.FloorRepo;
import com.simbirsoft.con_calc.view.FrameRepo;
import com.simbirsoft.con_calc.view.HoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/newFrame")
public class AddFloorController {

    @Autowired
    private FloorRepo floorRepo;

    @Autowired
    private FloorService floorService;

    @Autowired
    private HoleRepo holeRepo;

    @Autowired
    private HoleService holeService;

    @Autowired
    MaterialService materialService;

    @Autowired
    WallCladdingService wallCladdingService;

    @Autowired
    FloorResultsService floorResultsService;

    @Autowired
    CustomerService customerService;

    @Autowired
    FrameRepo frameRepo;

    @GetMapping("/add")
    public String addFloorPage(
            @RequestParam(required = true, defaultValue = "") Long customerId,
            @RequestParam(required = true, defaultValue = "") Long orderId,
            Model model
    ) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);

        return "newFloor";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam(required = true, defaultValue = "") Long customerId,
            @RequestParam(required = true, defaultValue = "") String outOsbName,
            @RequestParam(required = true, defaultValue = "") String outWaterName,
            @RequestParam(required = true, defaultValue = "") String outWindName,
            @RequestParam(required = true, defaultValue = "") String outWarmName,
            @RequestParam(required = true, defaultValue = "") String overOsbName,
            @RequestParam(required = true, defaultValue = "") String overWaterName,
            @RequestParam(required = true, defaultValue = "") String overWindName,
            @RequestParam(required = true, defaultValue = "") String overWarmName,
            @RequestParam(required = true, defaultValue = "") String inOsbName,
            @RequestParam(required = true, defaultValue = "") Long orderId,
            @RequestParam(required = true, defaultValue = "") String adress,
            Floor floor,
            Hole hole,
            Model model
    ) {
        Frame order;
        if(orderId == null) {
            order = new Frame();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy");
            order.setLocalDateTime(formatForDateNow.format(dateNow));
            order.setAdress(adress);
            Customer customer = customerService.findCustomerById(customerId);
            order.setCustomer(customer);
            frameRepo.save(order);
        }
        else order = frameRepo.getById(orderId);

        if(order.getFloors() == null) {
            floor.setFirst(true);
            floor.setNumber(1);
        }
        else {
            floor.setFirst(false);
            floor.setNumber(
                    (order
                            .getFloors()
                            .stream()
                            .map(Floor::getNumber)
                            .sorted()
                            .reduce((a, b) -> b)
                            .get()) + 1
            );
        }
        model.addAttribute("floor", floor);
        model.addAttribute("hole", hole);

        floor.setFrame(order);
        floorRepo.save(floor);
        hole.setFloor(floor);
        holeRepo.save(hole);

        wallCladdingService
                .addOutWallCladding(outOsbName,outWaterName,outWindName,outWarmName, floor.getId());
        wallCladdingService
                .addInWallCladding(inOsbName, floor.getId());
        wallCladdingService
                .addOverWallCladding(overOsbName, overWaterName, overWindName, overWarmName, floor.getId());

        return "redirect:/calculate/" + floor.getId();
    }

    @GetMapping("/edit")
    public String editFloor (
            @RequestParam(required = true, defaultValue = "") Long floorId,
            Model model
    ) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("floorId", floorId);

        Floor floor = floorRepo.getById(floorId);
        model.addAttribute("floor", floor);
        model.addAttribute("holes", floor.getHoles());
        model.addAttribute("curOutOsb",floor.getFloorResults().getNameOfOutOsb());
        model.addAttribute("curOutWater",floor.getFloorResults().getNameOfOutWater());
        model.addAttribute("curOutWind",floor.getFloorResults().getNameOfOutWind());
        model.addAttribute("curOutWarm",floor.getFloorResults().getNameOfOutWarm());
        model.addAttribute("curInOsb",floor.getFloorResults().getNameOfInOsb());
        model.addAttribute("curOverOsb",floor.getFloorResults().getNameOfOverOsb());
        model.addAttribute("curOverWater",floor.getFloorResults().getNameOfOverWater());
        model.addAttribute("curOverWind",floor.getFloorResults().getNameOfOverWind());
        model.addAttribute("curOverWarm",floor.getFloorResults().getNameOfOverWarm());

        return "editFloor";
    }

    @PostMapping("/edit")
    public String edit (
            @RequestParam(required = true, defaultValue = "") Long floorId,
            @RequestParam(required = true, defaultValue = "") String outOsbName,
            @RequestParam(required = true, defaultValue = "") String outWaterName,
            @RequestParam(required = true, defaultValue = "") String outWindName,
            @RequestParam(required = true, defaultValue = "") String outWarmName,
            @RequestParam(required = true, defaultValue = "") String overOsbName,
            @RequestParam(required = true, defaultValue = "") String overWaterName,
            @RequestParam(required = true, defaultValue = "") String overWindName,
            @RequestParam(required = true, defaultValue = "") String overWarmName,
            @RequestParam(required = true, defaultValue = "") String inOsbName,
            @ModelAttribute("floor") Floor floor
    ) {
        floorService.updateFloor(floor, floorId);

        wallCladdingService
                .addOutWallCladding(outOsbName,outWaterName,outWindName,outWarmName, floorId);
        wallCladdingService
                .addInWallCladding(inOsbName, floorId);
        wallCladdingService
                .addOverWallCladding(overOsbName, overWaterName, overWindName, overWarmName, floorId);
        return "redirect:/calculate/" + floorId;
    }
}
