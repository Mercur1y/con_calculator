package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.foundation.FoundationCreationDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.dto.wallCladding.ValidDtoForFoundation;
import com.simbirsoft.con_calc.entity.Foundation;
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
@RequestMapping("/foundation")
public class FoundationController {

    private final MaterialService materialService;
    private final WallCladdingService wallCladdingService;
    private final FoundationService foundationService;
    private final OrderService orderService;
    private final FoundationResultsService foundationResultsService;

    @GetMapping("/new")
    public String addFoundationPage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            Model model
    ) {

        model.addAttribute("user", user);
        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);
        return "newFoundation";
    }

    @PostMapping("/new")
    public String save(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            @ModelAttribute("wc") @Valid ValidDtoForFoundation wc,
            @Valid FoundationCreationDto foundation
    ) {

        Order order = orderService.addGetOrder(orderId, customerId, adress);

        Foundation foundationEntity = foundationService.addFoundation(order, foundation);

        wallCladdingService
                .addFoundationMaterials(
                        wc.getNameOfPiles(),
                        wc.getNameOfConcrete(),
                        foundationEntity.getId());

        foundationResultsService.addUpdateResults(foundationEntity);

        return "redirect:/results?orderId=" + order.getId() + "&customerId=" + customerId;
    }

    @GetMapping
    public String editFoundationPage(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "") Long foundationId,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            Model model
    ) {

        model.addAttribute("user", user);
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("foundationId", foundationId);

        FoundationEditDto foundation = foundationService.getForEdit(foundationId);

        model.addAttribute("foundation", foundation);
        model.addAttribute("curConcrete", foundation.getFoundationResults().getNameOfConcrete());
        model.addAttribute("curPiles", foundation.getFoundationResults().getNameOfPiles());

        return "editFoundation";
    }

    @PostMapping
    public String edit(
            @RequestParam(defaultValue = "") Long foundationId,
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            @ModelAttribute("wc") @Valid ValidDtoForFoundation wc,
            @Valid FoundationEditDto foundation
    ) {

                foundationService.updateFoundation(foundation, foundationId);
        wallCladdingService
                .addFoundationMaterials(
                        wc.getNameOfPiles(),
                        wc.getNameOfConcrete(),
                        foundationId);

        Foundation foundationEntity = foundationService.findFoundationById(foundationId);
        foundationResultsService.addUpdateResults(foundationEntity);

        return "redirect:/results?orderId=" + orderId + "&customerId=" + customerId;
    }
}
