package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.floor.FloorCreationDto;
import com.simbirsoft.con_calc.dto.floor.FloorEditDto;
import com.simbirsoft.con_calc.dto.hole.HoleCreationDto;
import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Hole;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.mapper.FloorMapper;
import com.simbirsoft.con_calc.services.FloorService;
import com.simbirsoft.con_calc.services.MaterialService;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.services.WallCladdingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(defaultValue = "") String outOsbName,
            @RequestParam(defaultValue = "") String outWaterName,
            @RequestParam(defaultValue = "") String outWindName,
            @RequestParam(defaultValue = "") String outWarmName,
            @RequestParam(defaultValue = "") String overOsbName,
            @RequestParam(defaultValue = "") String overWaterName,
            @RequestParam(defaultValue = "") String overWindName,
            @RequestParam(defaultValue = "") String overWarmName,
            @RequestParam(defaultValue = "") String inOsbName,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            @ModelAttribute("floor") FloorCreationDto floor,
            @ModelAttribute("hole") HoleCreationDto hole
    ) {
        Order order = orderService.addGetOrder(orderId, customerId, adress);

        Floor floorEntity = floorService.addFloor(order, floor, hole);

        wallCladdingService
                .addOutWallCladding(outOsbName,outWaterName,outWindName,outWarmName, floorEntity.getId());
        wallCladdingService
                .addInWallCladding(inOsbName, floorEntity.getId());
        wallCladdingService
                .addOverWallCladding(overOsbName, overWaterName, overWindName, overWarmName, floorEntity.getId());

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
            @RequestParam(defaultValue = "") String outOsbName,
            @RequestParam(defaultValue = "") String outWaterName,
            @RequestParam(defaultValue = "") String outWindName,
            @RequestParam(defaultValue = "") String outWarmName,
            @RequestParam(defaultValue = "") String overOsbName,
            @RequestParam(defaultValue = "") String overWaterName,
            @RequestParam(defaultValue = "") String overWindName,
            @RequestParam(defaultValue = "") String overWarmName,
            @RequestParam(defaultValue = "") String inOsbName,
            @ModelAttribute("floor") FloorEditDto floor
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
