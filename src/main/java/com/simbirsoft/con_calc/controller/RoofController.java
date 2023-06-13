package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.roof.RoofCreationDto;
import com.simbirsoft.con_calc.dto.roof.RoofEditDto;
import com.simbirsoft.con_calc.dto.wallCladding.ValidDtoForRoof;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.entity.Roof;
import com.simbirsoft.con_calc.entity.User;
import com.simbirsoft.con_calc.mapper.RoofMapper;
import com.simbirsoft.con_calc.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/roof")
public class RoofController {

    private final MaterialService materialService;
    private final OrderService orderService;
    private final RoofService roofService;
    private final RoofResultsService roofResultsService;
    private final WallCladdingService wallCladdingService;

    @GetMapping("/new")
    public String addRoofPage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String type,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("type", type);

        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("top", materialService.getTopMaterials());

        return "newRoof";
    }

    @PostMapping("/new")
    public String save(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            @RequestParam(defaultValue = "") String type,
            @ModelAttribute("wc") @Valid ValidDtoForRoof wc,
            RoofCreationDto roof
    ) {

        Order order = orderService.addGetOrder(orderId, customerId, adress);

        roof.setType(Integer.parseInt(type));
        Roof roofEntity = roofService.addRoof(order, roof);

        wallCladdingService
                .addRoofWallCladding(
                        wc.getNameOfWater(),
                        wc.getNameOfTop(),
                        wc.getNameOfWarm(),
                        roofEntity.getId());

        roofResultsService.addUpdateResults(roofEntity);

        return "redirect:/results?orderId=" + order.getId() + "&customerId=" + customerId;
    }

    @GetMapping
    public String editRoofPage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long roofId,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            Model model
    ) {

        model.addAttribute("user", user);
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);

        model.addAttribute("water", materialService.getWaterProofMaterials());
        model.addAttribute("warm", materialService.getWarmProofMaterials());
        model.addAttribute("top", materialService.getTopMaterials());
        model.addAttribute("roofId", roofId);

        RoofEditDto roof = roofService.getForEdit(roofId);

        model.addAttribute("roof", roof);
        model.addAttribute("results", roof.getRoofResults());

        return "editRoof";
    }

    @PostMapping
    public String edit(
            @RequestParam(defaultValue = "") Long roofId,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @ModelAttribute("wc") @Valid ValidDtoForRoof wc,
            @Valid RoofEditDto roof
    ) {

        roofService.updateRoof(roof, roofId);
        wallCladdingService
                .addRoofWallCladding(
                        wc.getNameOfTop(),
                        wc.getNameOfWarm(),
                        wc.getNameOfWater(),
                        roofId);

        Roof roofEntity = roofService.findRoofById(roofId);
        roofResultsService.addUpdateResults(roofEntity);

        return "redirect:/results?orderId=" + orderId + "&customerId=" + customerId;
    }
}
