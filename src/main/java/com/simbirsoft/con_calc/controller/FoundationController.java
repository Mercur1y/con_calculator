package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.dto.foundation.FoundationCreationDto;
import com.simbirsoft.con_calc.dto.foundation.FoundationEditDto;
import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.services.FoundationService;
import com.simbirsoft.con_calc.services.MaterialService;
import com.simbirsoft.con_calc.services.OrderService;
import com.simbirsoft.con_calc.services.WallCladdingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/foundation")
public class FoundationController {

    private final MaterialService materialService;
    private final WallCladdingService wallCladdingService;
    private final FoundationService foundationService;
    private final OrderService orderService;

    @GetMapping("/add")
    public String addFoundationPage(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") Long orderId,
            Model model
    ) {

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("customerId", customerId);
        model.addAttribute("orderId", orderId);
        return "newFoundation";
    }

    @PostMapping("/add")
    public String save(
            @RequestParam(defaultValue = "") Long customerId,
            @RequestParam(defaultValue = "") String pilesName,
            @RequestParam(defaultValue = "") String concreteName,
            @RequestParam(defaultValue = "") Long orderId,
            @RequestParam(defaultValue = "") String adress,
            FoundationCreationDto foundation
    ) {

        Order order = orderService.addGetOrder(orderId, customerId, adress);

        Foundation foundationEntity = foundationService.addFoundation(order, foundation);

        wallCladdingService
                .addFoundationMaterials
                        (pilesName, concreteName, foundationEntity.getId());

        return "redirect:/calculate/foundation/" + foundationEntity.getId();
    }

    @GetMapping("/edit")
    public String editFoundationPage(
            @RequestParam(defaultValue = "") Long foundationId,
            Model model
    ) {

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("foundationId", foundationId);

        FoundationEditDto foundation = foundationService.getForEdit(foundationId);

        model.addAttribute("foundation", foundation);
        model.addAttribute("curConcrete", foundation.getFoundationResults().getNameOfConcrete());
        model.addAttribute("curPiles", foundation.getFoundationResults().getNameOfPiles());

        return "editFoundation";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam(defaultValue = "") Long foundationId,
            @RequestParam(defaultValue = "") String pilesName,
            @RequestParam(defaultValue = "") String concreteName,
            @ModelAttribute("foundation") FoundationEditDto foundation
    ) {
        foundationService.updateFoundation(foundation, foundationId);
        wallCladdingService
                .addFoundationMaterials(pilesName, concreteName, foundationId);

        return "redirect:/calculate/foundation/" + foundationId;
    }
}
