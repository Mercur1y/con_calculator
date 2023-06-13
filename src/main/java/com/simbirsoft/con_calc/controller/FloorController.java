package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleCreationDto;
import com.simbirsoft.con_calc.dto.wallCladding.ValidDtoForFloor;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/floor")
public class FloorController {

    private final FloorService floorService;
    private final MaterialService materialService;
    private final WallCladdingService wallCladdingService;
    private final OrderService orderService;
    private final FloorResultsService floorResultsService;

    @GetMapping("/new")
    public String addFloorPage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);

        return "newFloor";
    }

    @PostMapping("/new")
    public String save(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            @ModelAttribute("wc") @Valid ValidDtoForFloor wc,
            @ModelAttribute("floor") @Valid FloorCreationDto floor,
            @ModelAttribute("hole") @Valid HoleCreationDto hole
    ) {

        Order order = orderService.addGetOrder(orderId, customerId, adress);

        Floor floorEntity = floorService.addFloor(order, floor, hole);

        wallCladdingService
                .addOutWallCladding(
                        wc.getNameOfOutOsb(),
                        wc.getNameOfOutWater(),
                        wc.getNameOfOutWind(),
                        wc.getNameOfOutWarm(),
                        floorEntity.getId()
                );
        wallCladdingService
                .addInWallCladding(wc.getNameOfInOsb(), floorEntity.getId());
        wallCladdingService
                .addOverWallCladding(
                        wc.getNameOfOverOsb(),
                        wc.getNameOfOverWater(),
                        wc.getNameOfOverWind(),
                        wc.getNameOfOverWarm(),
                        floorEntity.getId()
                );

        floorResultsService.addUpdateResults(floorEntity);

        return "redirect:/results?orderId=" + floorEntity.getOrder().getId() + "&customerId=" + customerId;
    }

    @GetMapping
    public String editFloor(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") Long floorId,
            Model model
    ) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("floorId", floorId);

        model.addAttribute("user", user);
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);

        FloorEditDto floor = floorService.getForEdit(floorId);

        model.addAttribute("floor", floor);
        model.addAttribute("floorId", floorId);
        model.addAttribute("results", floor.getFloorResults());

        return "editFloor";
    }

    @PostMapping
    public String edit(
            @RequestParam(defaultValue = "") Long floorId,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @ModelAttribute("wc") @Valid ValidDtoForFloor wc,
            @ModelAttribute("floor") @Valid FloorEditDto floor
    ) {

        floorService.updateFloor(floor, floorId);

        wallCladdingService
                .addOutWallCladding(
                        wc.getNameOfOutOsb(),
                        wc.getNameOfOutWater(),
                        wc.getNameOfOutWind(),
                        wc.getNameOfOutWarm(),
                        floorId
                );
        wallCladdingService
                .addInWallCladding(wc.getNameOfInOsb(), floorId);
        wallCladdingService
                .addOverWallCladding(
                        wc.getNameOfOverOsb(),
                        wc.getNameOfOverWater(),
                        wc.getNameOfOverWind(),
                        wc.getNameOfOverWarm(),
                        floorId
                );

        Floor floorEntity = floorService.findFloorById(floorId);
        floorResultsService.addUpdateResults(floorEntity);

        return "redirect:/results?orderId=" + orderId + "&customerId=" + customerId;
    }
}
