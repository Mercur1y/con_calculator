package com.simbirsoft.con_calc.controller;

import com.simbirsoft.con_calc.entity.Foundation;
import com.simbirsoft.con_calc.entity.Order;
import com.simbirsoft.con_calc.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foundation")
public class FoundationController {

    final MaterialService materialService;
    final CustomerService customerService;
    final WallCladdingService wallCladdingService;
    final FoundationService foundationService;
    final OrderService orderService;

    public FoundationController(MaterialService materialService, CustomerService customerService, WallCladdingService wallCladdingService, FoundationService foundationService, OrderService orderService) {
        this.materialService = materialService;
        this.customerService = customerService;
        this.wallCladdingService = wallCladdingService;
        this.foundationService = foundationService;
        this.orderService = orderService;
    }

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
            Foundation foundation
    ) {

        Order order = orderService.addGetOrder(orderId, customerId, adress);

        foundationService.addFoundation(order, foundation);

        wallCladdingService.addFoundationMaterials(pilesName, concreteName, foundation.getId());

        return "redirect:/calculate/foundation/" + foundation.getId();
    }

    @GetMapping("/edit")
    public String editFoundationPage(
            @RequestParam(defaultValue = "") Long foundationId,
            Model model
    ) {

        model.addAttribute("piles", materialService.getPilesMaterials());
        model.addAttribute("concrete", materialService.getConcreteMaterials());
        model.addAttribute("foundationId", foundationId);

        Foundation foundation = foundationService.findFoundationById(foundationId);
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
            @ModelAttribute("foundation") Foundation foundation
    ) {
        foundationService.updateFoundation(foundation, foundationId);
        wallCladdingService.addFoundationMaterials(pilesName, concreteName, foundationId);

        return "redirect:/calculate/foundation/" + foundationId;
    }
}
