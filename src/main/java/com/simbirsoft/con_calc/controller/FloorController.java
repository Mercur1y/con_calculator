package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleCreationDto;
import com.simbirsoft.con_calc.dto.wallCladding.ValidDtoForFloor;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.FloorMapper;
import com.simbirsoft.con_calc.services.FloorService;
import com.simbirsoft.con_calc.services.MaterialService;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.services.WallCladdingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/floor")
public class FloorController {

    private final FloorService floorService;
    private final MaterialService materialService;
    private final WallCladdingService wallCladdingService;
    private final OrderService orderService;
    private final FloorMapper floorMapper;

    @GetMapping("/add")
    public String addFloorPage(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
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
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            @ModelAttribute("wc") @Valid ValidDtoForFloor wc,
            @ModelAttribute("floor") @Valid FloorCreationDto floor,
            @ModelAttribute("hole") @Valid HoleCreationDto hole,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = UtilsController.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "newFloor";
        }

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

        return "redirect:/calculate/" + floorEntity.getId();
    }

    @GetMapping("/edit")
    public String editFloor (
            @RequestParam(defaultValue = "") Long floorId,
            Model model
    ) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("floorId", floorId);

        FloorEditDto floor = floorService.getForEdit(floorId);

        model.addAttribute("floor", floor);
        model.addAttribute("results", floor.getFloorResults());

        return "editFloor";
    }

    @PostMapping("/edit")
    public String edit (
            @RequestParam(defaultValue = "") Long floorId,
            @ModelAttribute("wc") @Valid ValidDtoForFloor wc,
            @ModelAttribute("floor") @Valid FloorEditDto floor,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = UtilsController.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "editFloor";
        }

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
        return "redirect:/calculate/" + floorId;
    }
}
