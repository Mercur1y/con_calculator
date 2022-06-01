package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Floor;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.Hole;
import com.simbirsoft.con_calc.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/floor")
public class FloorController {

    final FloorService floorService;
    final MaterialService materialService;
    final WallCladdingService wallCladdingService;
    final FloorResultsService floorResultsService;
    final CustomerService customerService;
    final OrderService orderService;

    public FloorController(FloorService floorService, MaterialService materialService, WallCladdingService wallCladdingService, FloorResultsService floorResultsService, CustomerService customerService, OrderService orderService) {
        this.floorService = floorService;
        this.materialService = materialService;
        this.wallCladdingService = wallCladdingService;
        this.floorResultsService = floorResultsService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

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
            @ModelAttribute("floor") Floor floor,
            @ModelAttribute("hole") Hole hole
    ) {
        Order order = orderService.addGetOrder(orderId, customerId, adress);

        floorService.addFloor(order, floor, hole);

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
            @RequestParam(defaultValue = "") Long floorId,
            Model model
    ) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("floorId", floorId);

        Floor floor = floorService.findFloorById(floorId);
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
