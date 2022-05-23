package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.*;
import com.simbirsoft.con_calc.services.CustomerService;
import com.simbirsoft.con_calc.services.FloorResultsService;
import com.simbirsoft.con_calc.services.MaterialService;
import com.simbirsoft.con_calc.services.WallCladdingService;
import com.simbirsoft.con_calc.view.FloorRepo;
import com.simbirsoft.con_calc.view.FrameRepo;
import com.simbirsoft.con_calc.view.HoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@Controller
@RequestMapping("/newFrame/")
public class AddFloorController {

    @Autowired
    private FloorRepo floorRepo;

    @Autowired
    private HoleRepo holeRepo;

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

    @GetMapping("{id}")
    public String addFloorPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("osb", materialService.getOsbMaterials());
        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("wind", materialService.getWindProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());

        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "newFloor";
    }

    @PostMapping("{customer}")
    public String save(
            @PathVariable
            @ModelAttribute("customer") Customer customer,
            @RequestParam(required = true, defaultValue = "" ) Long outOsbId,
            @RequestParam(required = true, defaultValue = "" ) Long outWaterId,
            @RequestParam(required = true, defaultValue = "" ) Long outWindId,
            @RequestParam(required = true, defaultValue = "" ) Long outWarmId,
            @RequestParam(required = true, defaultValue = "" ) Long overOsbId,
            @RequestParam(required = true, defaultValue = "" ) Long overWaterId,
            @RequestParam(required = true, defaultValue = "" ) Long overWindId,
            @RequestParam(required = true, defaultValue = "" ) Long overWarmId,
            @RequestParam(required = true, defaultValue = "" ) Long inOsbId,
            Floor floor,
            Frame frame,
            Hole hole,
            Model model
    ) {
        model.addAttribute("hole", hole);
        model.addAttribute("floor", floor);

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy");

        frame.setLocalDateTime(formatForDateNow.format(dateNow));
        frame.setCustomer(customer);
        frameRepo.save(frame);

        floor.setFrame(frame);
        floorRepo.save(floor);
        hole.setFloor(floor);
        holeRepo.save(hole);

        wallCladdingService
                .addOutWallCladding(outOsbId,outWaterId,outWindId,outWarmId, floor);
        wallCladdingService
                .addInWallCladding(inOsbId, floor);
        wallCladdingService
                .addOverWallCladding(overOsbId, overWaterId, overWindId, overWarmId, floor);

        return "redirect:/calculate/" + floor.getId();
    }
}
